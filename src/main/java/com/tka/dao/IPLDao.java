package com.tka.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tka.Utility.IPLUtility;
import com.tka.entity.Player;

public class IPLDao {

	
	Connection conn = null;
	PreparedStatement st = null;
	ResultSet rs = null;

	public IPLDao() {
		IPLUtility u = new IPLUtility();
		conn = u.connect();
	}
	public List<Player> getList() {
		String Query = "select * from player";
		List<Player> player = new ArrayList<Player>();
		try {
			st = conn.prepareStatement(Query);
			rs = st.executeQuery();
			while (rs.next()) {
				int pid = rs.getInt(1);
				int jn = rs.getInt(2);
				String name = rs.getString(3);
				int runs = rs.getInt(4);
				int wk = rs.getInt(5);
				String role = rs.getString(6);
				String tname = rs.getString(7);
				Player p = new Player(pid, jn, name, runs, wk, role, tname);
				player.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return player;
	}
	public int Insertdata(Player p) {
		
		String query="Insert into player values(?,?,?,?,?,?,?)";
		try {
			st=conn.prepareStatement(query);
			st.setInt(1, p.getPid());
			st.setInt(2,p.getJn());
			st.setString(3, p.getPname());
			st.setInt(4, p.getRuns());
			st.setInt(5, p.getWickets());
			st.setString(6, p.getRole());
			st.setString(7, p.getTname());
			
			int insert=st.executeUpdate();
			return insert ;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return 0 ;
	}
	public int updatedate(int i, int j) {
		String Query="update player set runs=? where pid=?";
		try {
			st=conn.prepareStatement(Query);
			st.setInt(1, i);
			st.setInt(2, j);
			int update=st.executeUpdate();
			return update;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	public int deletedata(int i) {
		String Query="delete from player where pid=?";
		try {
			st=conn.prepareStatement(Query);
			st.setInt(1, i);
			int l=st.executeUpdate();
			return l;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}