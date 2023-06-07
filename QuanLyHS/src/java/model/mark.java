/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author anhha
 */
public class mark {
    private double m1;
    private double m2;
    private double pt1;
    private double pt2;
    private double mt;
    private double fe;
    private double avag;
    private String suid;
    private String sid;
    private int years;

    public mark(double m1, double m2, double pt1, double pt2, double mt, double fe, double avag, String suid, String sid, int years) {
        this.m1 = m1;
        this.m2 = m2;
        this.pt1 = pt1;
        this.pt2 = pt2;
        this.mt = mt;
        this.fe = fe;
        this.avag = avag;
        this.suid = suid;
        this.sid = sid;
        this.years = years;
    }

    public double getM1() {
        return m1;
    }

    public void setM1(double m1) {
        this.m1 = m1;
    }

    public double getM2() {
        return m2;
    }

    public void setM2(double m2) {
        this.m2 = m2;
    }

    public double getPt1() {
        return pt1;
    }

    public void setPt1(double pt1) {
        this.pt1 = pt1;
    }

    public double getPt2() {
        return pt2;
    }

    public void setPt2(double pt2) {
        this.pt2 = pt2;
    }

    public double getMt() {
        return mt;
    }

    public void setMt(double mt) {
        this.mt = mt;
    }

    public double getFe() {
        return fe;
    }

    public void setFe(double fe) {
        this.fe = fe;
    }

    public double getAvag() {
        return avag;
    }

    public void setAvag(double avag) {
        this.avag = avag;
    }

    public String getSuid() {
        return suid;
    }

    public void setSuid(String suid) {
        this.suid = suid;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    

  
    
}
