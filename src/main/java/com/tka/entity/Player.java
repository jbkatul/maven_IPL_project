package com.tka.entity;

public class Player {

	private int pid;
	private int jn;
	private String pname;
	private int runs;
	private int wickets;
	private String role;
	private String tname;
	
	public Player() {
		
	}
	public Player(int pid, int jn, String pname, int runs, int wickets, String role, String tname) {
		super();
		this.pid = pid;
		this.jn = jn;
		this.pname = pname;
		this.runs = runs;
		this.wickets = wickets;
		this.role = role;
		this.tname = tname;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public int getJn() {
		return jn;
	}
	public void setJn(int jn) {
		this.jn = jn;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getRuns() {
		return runs;
	}
	public void setRuns(int runs) {
		this.runs = runs;
	}
	public int getWickets() {
		return wickets;
	}
	public void setWickets(int wickets) {
		this.wickets = wickets;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	@Override
	public String toString() {
		return "Player [pid=" + pid + ", jn=" + jn + ", pname=" + pname + ", runs=" + runs + ", wickets=" + wickets
				+ ", role=" + role + ", tname=" + tname + "]\n";
	}
	
	
}
