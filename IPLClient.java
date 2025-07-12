package com.tka.client;

import java.util.List;
import com.tka.controller.IPLController;
import com.tka.entity.Player;

public class IPLClient {

    public static void main(String[] args) {

        System.out.println("Welcome to the IPL Client Application!");

        IPLController iplController = new IPLController();

     
        List<Player> allplayers = iplController.getList();
        System.out.println("All Players:\n" + allplayers);
 // Get Bowlers from MI
        List<Player> bowlers = iplController.BatsmanOrBowler("mi", "bowler");
        System.out.println("\nPlayers in MI Team who are Bowlers:");
        for (Player player : bowlers) {
            System.out.println(player);
        }

      
        List<Player> vPlayers = iplController.getPlayersByTeamAndNameStart1("mi", 'v');
        System.out.println("\nPlayers from MI whose names start with 'V':");
        for (Player player : vPlayers) {
            System.out.println(player);
        }

       
    }
}
