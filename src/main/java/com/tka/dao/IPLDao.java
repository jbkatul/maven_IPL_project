package com.tka.dao;

import java.sql.*;
import java.util.*;

import com.tka.entity.Player;
import com.tka.utility.SQLUtility;

public class IPLDao {

	Connection connection = null;
	ResultSet resultSet = null;
	PreparedStatement preparedStatement = null;

	String url = "jdbc:mysql://localhost:3306/advjava226db";
	String user = "root";
	String password = "root";
	String selectAllQuery = "SELECT * FROM player";
	String insertQuery = "INSERT INTO player VALUES (?, ?, ?, ?, ?, ?)";
	String updateQuery = "UPDATE player SET jn=?, pname=?, runs=?, wickets=?, tname=? WHERE pid=?";
	String deleteQuery = "DELETE FROM player WHERE pid=?";
	String batsmanQuery = "SELECT * FROM player WHERE tname=? AND runs > 0";
	String bowlerQuery = "SELECT * FROM player WHERE tname=? AND wickets > 0";

	public List<Player> getAllPlayers() {
		System.out.println("In IPLDao.getAllPlayers()");
		List<Player> playerList = new ArrayList<>();

		try {
			connection = SQLUtility.getConnection();
			preparedStatement = connection.prepareStatement(selectAllQuery);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				playerList.add(mapResultSetToPlayer(resultSet));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}

		return playerList;
	}

	public List<Player> getAllBatsman(String teamName) {
		List<Player> list = new ArrayList<>();
		try {
			connection = SQLUtility.getConnection();
			preparedStatement = connection.prepareStatement(batsmanQuery);
			preparedStatement.setString(1, teamName);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				list.add(mapResultSetToPlayer(resultSet));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
		return list;
	}

	public List<Player> getAllBallers(String teamName) {
		List<Player> list = new ArrayList<>();
		try {
			connection = SQLUtility.getConnection();
			preparedStatement = connection.prepareStatement(bowlerQuery);
			preparedStatement.setString(1, teamName);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				list.add(mapResultSetToPlayer(resultSet));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
		return list;
	}

	public int insertPlayer(Player player) {
		int ack = 0;
		try {
			connection = SQLUtility.getConnection();
			preparedStatement = connection.prepareStatement(insertQuery);

			preparedStatement.setInt(1, player.getPid());
			preparedStatement.setInt(2, player.getJn());
			preparedStatement.setString(3, player.getPname());
			preparedStatement.setInt(4, player.getRuns());
			preparedStatement.setInt(5, player.getWickets());
			preparedStatement.setString(6, player.getTname());

			ack = preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
		return ack;
	}

	public int updatePlayer(Player player) {
		int ack = 0;
		try {
			connection = SQLUtility.getConnection();
			preparedStatement = connection.prepareStatement(updateQuery);

			preparedStatement.setInt(1, player.getJn());
			preparedStatement.setString(2, player.getPname());
			preparedStatement.setInt(3, player.getRuns());
			preparedStatement.setInt(4, player.getWickets());
			preparedStatement.setString(5, player.getTname());
			preparedStatement.setInt(6, player.getPid());

			ack = preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
		return ack;
	}

	public int deletePlayer(int pid) {
		int ack = 0;
		try {
			connection = SQLUtility.getConnection();
			preparedStatement = connection.prepareStatement(deleteQuery);
			preparedStatement.setInt(1, pid);
			ack = preparedStatement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
		return ack;
	}

	private Player mapResultSetToPlayer(ResultSet rs) throws SQLException {
		return new Player(rs.getInt("pid"), rs.getInt("jn"), rs.getString("pname"), rs.getInt("runs"),
				rs.getInt("wickets"), rs.getString("tname"));
	}

	private void closeResources() {
		try {
			if (resultSet != null)
				resultSet.close();
			if (preparedStatement != null)
				preparedStatement.close();
			if (connection != null)
				connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
