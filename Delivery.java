package com.poorwa.ipl;

public class Delivery {
    private Integer id;
    private String battingTeam;
    private Integer extraRun;
    private Integer over;
    private String bowler;
    private Integer totalRungGivenByBowler;
    private Integer isSuperOver;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBattingTeam() {
        return battingTeam;
    }

    public void setBattingTeam(String battingTeam) {
        this.battingTeam = battingTeam;
    }

    public Integer getExtraRun() {
        return extraRun;
    }

    public void setExtraRun(Integer extraRun) {
        this.extraRun = extraRun;
    }

    public Integer getOver() {
        return over;
    }

    public void setOver(Integer over) {
        this.over = over;
    }

    public String getBowler() {
        return bowler;
    }

    public void setBowler(String bowler) {
        this.bowler = bowler;
    }

    public Integer getTotalRungGivenByBowler() {
        return totalRungGivenByBowler;
    }

    public void setTotalRungGivenByBowler(Integer totalRungGivenByBowler) {
        this.totalRungGivenByBowler = totalRungGivenByBowler;
    }

    public Integer getIsSuperOver() {
        return isSuperOver;
    }

    public void setIsSuperOver(Integer isSuperOver) {
        this.isSuperOver = isSuperOver;
    }
}
