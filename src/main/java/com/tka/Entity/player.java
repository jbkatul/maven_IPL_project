package com.tka.Entity;

public class player {

    private int pid;
    private int jn;
    private String pname;
    private int runs;
    private int wicket;
    private String tname;

    public player() {
        super();
    }

    public player(int pid, int jn, String pname, int runs, int wicket, String tname) {
        super();
        this.pid = pid;
        this.jn = jn;
        this.pname = pname;
        this.runs = runs;
        this.wicket = wicket;
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

    public int getWicket() {
        return wicket;
    }

    public void setWicket(int wicket) {
        this.wicket = wicket;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    @Override
    public String toString() {
        return "Player [pid=" + pid + ", jn=" + jn + ", pname=" + pname +
               ", runs=" + runs + ", wicket=" + wicket + ", tname=" + tname + "]\n";
    }
}
