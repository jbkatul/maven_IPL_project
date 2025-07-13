package com.tka.service;

import java.util.ArrayList;
import java.util.List;

import com.tka.controller.IPLController;
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
	
	 // ✅ NEW METHOD
    public List<Player> getPlayersByRuns(int runs) {
        List<Player> list = getList();
        List<Player> result = new ArrayList<>();
        for (Player p : list) {
            if (p.getRuns() > runs) {
                result.add(p);
            }
        
     
        }
		return result;

    }
 // ✅ NEW METHOD: players with name length less than 4 letters
 	public List<Player> getPlayersWithShortNames() {
 		List<Player> list = getList();
 		List<Player> result = new ArrayList<>();
 		for (Player p : list) {
 			if (p.getPname().length() < 4) {
 				result.add(p);
 			}
 		}
 		return result;
 	}
 
}