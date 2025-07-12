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

	public List<Player> getRunsWickets() {
		List<Player> pl = getList();
		List<Player> player = new ArrayList<>();
		
		for(Player p : pl) {
			if(p.getRuns() > 2000 && p.getWickets() >500) {
				player.add(p);
			}
		}
		
		
		return player;
	}
    
	
    
}
