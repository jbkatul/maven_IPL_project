package com.tka.dao;

import java.sql.*;
import java.util.*;

import com.tka.entity.Player;
import com.tka.utility.SQLUtility;

public class IPLDao {

    Connection connection = null;
    ResultSet resultSet = null;
    PreparedStatement preparedStatement = null;

    String selectAllQuery = "SELECT * FROM player";
    String insertQuery = "INSERT INTO player VALUES (?, ?, ?, ?, ?, ?, ?)";
    String updateQuery = "UPDATE player SET runs=? WHERE pid=?";
    String deleteQuery = "DELETE FROM player WHERE pid=?";

    public List<Player> getAllPlayers() {
        List<Player> players = new ArrayList<>();
        try {
            connection = SQLUtility.getConnection();
            preparedStatement = connection.prepareStatement(selectAllQuery);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Player p = new Player(
                    resultSet.getInt("pid"),
                    resultSet.getInt("jn"),
                    resultSet.getString("pname"),
                    resultSet.getInt("runs"),
                    resultSet.getInt("wickets"),
                    resultSet.getString("role"),
                    resultSet.getString("tname")
                );
                players.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return players;
    }

    public int insertPlayer(Player p) {
        try {
            connection = SQLUtility.getConnection();
            preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setInt(1, p.getPid());
            preparedStatement.setInt(2, p.getJn());
            preparedStatement.setString(3, p.getPname());
            preparedStatement.setInt(4, p.getRuns());
            preparedStatement.setInt(5, p.getWickets());
            preparedStatement.setString(6, p.getRole());
            preparedStatement.setString(7, p.getTname());
            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return 0;
    }

    public int updatePlayerStats(int runs, int pid) {
        try {
            connection = SQLUtility.getConnection();
            preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setInt(1, runs);
            preparedStatement.setInt(2, pid);
            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return 0;
    }

    public int deletePlayer(int pid) {
        try {
            connection = SQLUtility.getConnection();
            preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setInt(1, pid);
            return preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }
        return 0;
    }

    private void closeResources() {
        try {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
            if (connection != null) connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
