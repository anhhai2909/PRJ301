/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author anhha
 */
public class classes {
    private String cid;
    private String name;
    private int numofst;
    private String tid;
    private int years;

    public classes(String cid, String name, int numofst, String tid,int years) {
        this.cid = cid;
        this.name = name;
        this.numofst = numofst;
        this.tid = tid;
        this.years = years;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumofst() {
        return numofst;
    }

    public void setNumofst(int numofst) {
        this.numofst = numofst;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }
    
    
}
