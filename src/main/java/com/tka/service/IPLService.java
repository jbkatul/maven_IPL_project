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

	public List<Player> getBestPlayers() {
		Player player = new Player();
		List<Player> bestPlayers = new ArrayList<>();
		List<Player> allPlayers = this.getList();
		Player bestBatsman = null;
		Player bestBowler = null;
		int maxRuns = 0;
		int maxsWK = 0;
		for (Player p : allPlayers) {

			if (p.getRuns() > maxRuns) {

				maxRuns = p.getRuns();
				bestBatsman = p;
			}
			if (p.getWickets() > maxsWK) {

				maxsWK = p.getWickets();
				bestBowler = p;
			}
		}
		if (bestBatsman != null) {
			bestPlayers.add(bestBatsman);
		}
		if (bestBowler != null) {
			bestPlayers.add(bestBowler);
		}

		return bestPlayers;
	}


    }
    public List<Player> getPlayersByRunsRange(int minruns, int maxruns) {
        List<Player> allPlayers = getList();
        List<Player> filteredPlayers = new ArrayList<>();
        
        for(Player player : allPlayers) {
            if(player.getRuns() >= minruns && player.getRuns() <= maxruns) {
                filteredPlayers.add(player);
            }
        }
        return filteredPlayers; 
    }

	}

	public Player getPlayerWithMaxRuns() {
		IPLDao d = new IPLDao();
		return d.getList().stream().max((p1, p2) -> Integer.compare(p1.getRuns(), p2.getRuns())).orElse(null);
	}



}
