package com.tka.client;

import java.util.List;

import com.tka.controller.IPLController;
import com.tka.entity.Player;

public class IPLClient {

	public static void main(String[] args) {

		System.out.println("Welcome to the IPL Client Application!");
		//Fetch all Data From Table
		IPLController iplController = new IPLController();
		List<Player> allplayers = iplController.getList();
		System.out.println(allplayers);
	
//InsertData
		
//		Players p=new Players(22, 21, "Shreyas Iyer", 3500, 10, "Batsman", "PBSK");
//		int l=iplController.Insertdata(p);
//		if(l!=0) {
//			System.out.println("Data Inserted");
//		}
//		else {
//			System.out.println("Data not Inserted");
//		}

		//Update data
		
//		int l=iplController.updatedata(2200,8);
//		if(l!=0) {
//			System.out.println("Data Updated");
//		}
//		else {
//			System.out.println("Data not updated");
//		}
		
		//Delete Data
		
//		int l=iplController.deletedata(22);
//		if(l!=0) {
//			System.out.println("Data Deleted");
//		}
//		else {
//			System.out.println("Data Not Deleted");
//		}
	
		//batsman/bowler
		
		List<Player> p=iplController.BatsmanOrBowler("mi","bowler");
		System.out.println("Player who is in mi Team And Who is Batsman\n" +p);
		

        // New method: players with runs greater than given number
        List<Player> topScorers = iplController.getPlayersByRuns(5000);
        System.out.println("Players with runs greater than 5000:\n" + topScorers);
       
        //Method that gives BEST PLAYERS
        List<Player>bestPlayers=iplController.getBestPlayers();
        System.out.println("BEST PLAYERS based on maximum runs scored and most wickets taken");
        System.out.println("Best Batsman : "+bestPlayers.get(0));
        System.out.println("Best Bowler : "+bestPlayers.get(1));
        
	}

}
