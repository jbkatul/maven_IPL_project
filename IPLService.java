package com.tka.service;

import java.util.ArrayList;
import java.util.List;

import com.tka.dao.IPLDao;
import com.tka.entity.Player;

public class IPLService {

	public List<Player> getList() {
		IPLDao d = new IPLDao();
		List<Player> l = d.getList();
		return l;
	}

	public int Insertdata(Player p) {
		IPLDao d = new IPLDao();
		int l = d.Insertdata(p);
		return l;
	}

	public int updatedata(int i, int j) {
		IPLDao d = new IPLDao();
		int l = d.updatedate(i, j);
		return l;
	}

	public int deletedata(int i) {
		IPLDao d = new IPLDao();
		int l = d.deletedata(i);
		return l;
	}

	public List<Player> BatsmanOrBowler(String tname, String role) {
		List<Player> filtered = new ArrayList<Player>();
		IPLDao d = new IPLDao();
		List<Player> p = d.getList();
		for (Player players : p) {
			if (players.getTname().equalsIgnoreCase(tname) && players.getRole().equalsIgnoreCase(role)) {
				filtered.add(players);
			}
		}
		return filtered;
	}

	@Override
    public List<Player> getPlayersWithRunsAbove(int minRuns) {
        List<Player> allPlayers = dao.getList(); // Assuming dao.getList() fetches all
        List<Player> filtered = new ArrayList<>();
        for (Player p : allPlayers) {
            if (p.getRuns() > minRuns) {
                filtered.add(p);
            }
        }
        return filtered;
    }
}