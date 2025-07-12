package com.tka.client;

import com.tka.entity.Player;
import com.tka.service.IPLService;

public class IPLClient {

	public static void main(String[] args) {

		IPLService service = new IPLService();

		Player topPlayer = service.getMostRunsPlayer();
		System.out.println(" Player with Most Runs: " + topPlayer);
	}

}
