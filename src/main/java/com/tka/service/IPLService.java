package com.tka.service;

import java.util.ArrayList;
import java.util.List;

import com.tka.dao.IPLDao;
import com.tka.entity.Player;

public class IPLService {

    private IPLDao iplDao = new IPLDao();

    public List<Player> getAllPlayers() {
        System.out.println("In IPLService.getAllPlayers()");
        return iplDao.getAllPlayers();
    }

    public List<Player> getAllPlayers(String tn) {
        List<Player> teamPlayers = new ArrayList<>();
        for (Player player : getAllPlayers()) {
            if (player.getTname().equalsIgnoreCase(tn)) {
                teamPlayers.add(player);
            }
        }
        return teamPlayers;
    }

    public List<Player> getAllbatsman(String teamName) {
        return iplDao.getAllBatsman(teamName);
    }

    public List<Player> getAllballers(String teamName) {
        return iplDao.getAllBallers(teamName);
    }

    public int insertPlayer(Player player) {
        return iplDao.insertPlayer(player);
    }

    public int updatePlayer(Player player) {
        return iplDao.updatePlayer(player);
    }

    public int deletePlayer(int pid) {
        return iplDao.deletePlayer(pid);
    }
}
