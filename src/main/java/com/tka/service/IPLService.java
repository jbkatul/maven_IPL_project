package com.tka.service;

import java.util.ArrayList;
import java.util.List;

import com.tka.dao.IPLDao;
import com.tka.entity.Player;

public class IPLService {

	public List<Player> getList() {
		IPLDao d=new IPLDao();
		List<Player> l=d.getList();
		return l;
	}

	public int Insertdata(Player p) {
		IPLDao d=new IPLDao();
		int l=d.Insertdata(p);
		return l;
	}

	public int updatedata(int i, int j) {
		IPLDao d=new IPLDao();
		int l=d.updatedate(i,j);
		return l;
	}

	public int deletedata(int i) {
		IPLDao d=new IPLDao();
		int l=d.deletedata(i);
		return l;
	}

	public List<Player> BatsmanOrBowler(String tname, String role) {
		List<Player> filtered=new ArrayList<Player>();
		IPLDao d=new IPLDao();
		List<Player> p=d.getList();
		for(Player players:p) {
			if(players.getTname().equalsIgnoreCase(tname) && players.getRole().equalsIgnoreCase(role)) {
				filtered.add(players);
			}
		}
		return filtered;
	}

	public List<Player> getPlayersByTeamAndNameStart1(String team, char startingLetter) {
	    IPLDao dao = new IPLDao();
	    List<Player> allPlayers = dao.getList(); 
	    List<Player> filteredPlayers = new ArrayList<Player>();

	    for (Player p : allPlayers) {
	        if ( p.getPname().toLowerCase().startsWith(String.valueOf(startingLetter).toLowerCase())) {
	            filteredPlayers.add(p);
	        }
	    }

	    return filteredPlayers;
	}

	

	
}