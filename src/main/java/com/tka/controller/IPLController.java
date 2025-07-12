package com.tka.controller;

import java.util.List;

import com.tka.entity.Player;
import com.tka.service.IPLService;

public class IPLController {

	public List<Player> getList() {
		IPLService s=new IPLService();
		List<Player> l=s.getList();
		return l;
	}

	public int Insertdata(Player p) {
		IPLService s=new IPLService();
		int l=s.Insertdata(p);
		return l;
	}

	public int updatedata(int i, int j) {
		IPLService s=new IPLService();
		int l=s.updatedata(i,j);
		return l;
	}

	public int deletedata(int i) {
		IPLService s=new IPLService();
		int l=s.deletedata(i);
		return l;
	}

	public List<Player> BatsmanOrBowler(String string1, String string2) {
		IPLService s=new IPLService();
		List<Player> l=s.BatsmanOrBowler(string1,string2);
		return l;
	}

	public List<Player> getPlayersByTeamAndNameStart1(String team, char startingLetter) {
	    IPLService s = new IPLService();
	    List<Player> l = s.getPlayersByTeamAndNameStart1(team, startingLetter);
	    return l;
	}
}