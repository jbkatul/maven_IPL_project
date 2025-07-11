package com.tka.service;
import java.util.LinkedList;
import java.util.List;

import com.tka.Dao.IPLDao;
import com.tka.Entity.player;
public class IPLService {
	
private IPLDao iplDao = null;
	
	public List<player> getAllPlayers() {
		System.out.println("In IPLService.getAllPlayers() method");
		
		iplDao = new IPLDao();
		List<player> allPlayersList = iplDao.getAllPlayers();
		
		return allPlayersList;
	}

	public int insertPlayer(player player) {
		iplDao = new IPLDao();
		int ack = iplDao.insertPlayer(player);
		
		return ack;
	}

	public int updatePlayer(int i, int j) {
		iplDao=new IPLDao();
		int ack2=iplDao.updatePlayer(i,j);
		return ack2;
	}

	

	public int deletePlayer(int d) {
		iplDao=new IPLDao();
		int ack3=iplDao.deletePlayer(d);
		return ack3;
	}

	public List<player> BatsmanOrBowler(int i)
	{
		List<player> bower=new LinkedList<>();
		List<player> batsman=new LinkedList<>();
		iplDao=new IPLDao();
		List<player> p=iplDao.getAllPlayers();
		for(player Players:p) {
			if(Players.getWicket()==0) {
				batsman.add(Players);
			}
			
		}
		return batsman;
		
	}

}
