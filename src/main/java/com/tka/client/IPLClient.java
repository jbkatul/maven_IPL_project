package com.tka.client;

import java.util.List;


import com.tka.Entity.player;
import com.tka.IPLController.IPLController;

public class IPLClient {

	public static void main(String[] args) {
		System.out.println("Welcome to ipl client application");
		  System.out.println("welcome to Ipl management system");
      	  System.out.println("In IPLUser class");
      	  
      	  IPLController iplcontroller=new IPLController();
      	  List<player> allplayer_list=iplcontroller.getAllPlayers();
      	  
 		System.out.println("allplayer list \n"+allplayer_list);

    //player player = new player(105, 33, "Ruturaj", 2300, 0, "CSK");
		
     //int ack = iplcontroller.insertplayer(player);
		
		
	//if (ack > 0) {		
		//System.out.println("Player inserted successfully");
	//} else {		
		//System.out.println("Player insertion failed");
		//}
	
	int i=iplcontroller.updatedata(5000,103);
	if (i != 0) 
	{		
		System.out.println("Player Updated Data successfully");
	} else
	{		
		System.out.println("Player Data Not Updated failed");
		}
	
	
	int D=iplcontroller.deleteplayer(103);
	if (D != 0) 
	{		
		System.out.println("Player  Data  deleted successfully");
	} else
	{		
		System.out.println("Player Data Not deleted ");
		}

	//batsman
	List<player> l=iplcontroller.BatsmanOrBowler(0);
	System.out.println(l);

	
	}	
	}


