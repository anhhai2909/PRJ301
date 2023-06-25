/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author anhha
 */
public class markavg {
    private String sid;
    private String cid;
    private double avg;
    private int years;

    public markavg(String sid, String cid, double avg, int years) {
        this.sid = sid;
        this.cid = cid;
        this.avg = avg;
        this.years = years;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    @Override
    public String toString() {
        return "markavg{" + "sid=" + sid + ", cid=" + cid + ", avg=" + avg + ", years=" + years + '}';
    }
    
}
