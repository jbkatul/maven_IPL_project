package com.tka.user;

import java.util.List;

import com.tka.controller.IPLController;
import com.tka.entity.Player;

public class IPLUser {
	public static void main(String[] args) {

		System.out.println(" Welcome to IPL User Management System");

		IPLController iplController = new IPLController();

		List<Player> allPlayers = iplController.getAllPlayers();
		System.out.println("\n All Players:");
		allPlayers.forEach(System.out::println);

		List<Player> batsmen = iplController.getAllbatsman("RCB");
		System.out.println("\n Batsmen from RCB:");
		batsmen.forEach(System.out::println);

		List<Player> bowlers = iplController.getAllballers("MI");
		System.out.println("\n Bowlers from MI:");
		bowlers.forEach(System.out::println);

		//Player newPlayer = new Player(210, 100, "SHERAYAS", 0, 4348, "PBKS");
		//int insertAck = iplController.insertPlayer(newPlayer);
		//System.out.println("\n Player Insertion: " + (insertAck > 0 ? "Success" : "Failed"));

		//newPlayer.setRuns(350);
		//int updateAck = iplController.updatePlayer(newPlayer);
		//System.out.println(" Player Update: " + (updateAck > 0 ? "Success" : "Failed"));

		//int deleteAck = iplController.deletePlayer(207);
		//System.out.println(" Player Deletion: " + (deleteAck > 0 ? "Success" : "Failed"));

		System.out.println("\n End of IPLUser class main method");
	}
}
