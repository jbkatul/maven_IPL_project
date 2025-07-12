package com.tka.controller;

import java.util.List;

import com.tka.entity.Player;
import com.tka.service.IPLService;

public class IPLController {

	private IPLService iplService = new IPLService();

	public List<Player> getAllPlayers() {
		System.out.println("In IPLController.getAllPlayers()");
		return iplService.getAllPlayers();
	}

	public List<Player> getAllPlayers(String teamName) {
		return iplService.getAllPlayers(teamName);
	}

	public List<Player> getAllbatsman(String teamName) {
		return iplService.getAllbatsman(teamName);
	}

	public List<Player> getAllballers(String teamName) {
		return iplService.getAllballers(teamName);
	}

	public int insertPlayer(Player player) {
		return iplService.insertPlayer(player);
	}

	public int updatePlayer(Player player) {
		return iplService.updatePlayer(player);
	}

	public int deletePlayer(int pid) {
		return iplService.deletePlayer(pid);
	}

	public Player getMostRunsPlayer() {
        return iplService.getMostRunsPlayer();
    }
}