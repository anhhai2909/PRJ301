/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author anhha
 */
public class news {
    private int nid;
    private Date udate;
    private String tid;
    private String info;
    private String shortd;

    public news() {
    }
    
    public news(int nid, Date udate, String tid, String info,String shortd) {
        this.nid = nid;
        this.udate = udate;
        this.tid = tid;
        this.info = info;
        this.shortd=shortd;
    }

    public int getNid() {
        return nid;
    }

    public void setNid(int nid) {
        this.nid = nid;
    }

    public Date getUdate() {
        return udate;
    }

    public void setUdate(Date udate) {
        this.udate = udate;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getShortd() {
        return shortd;
    }

    public void setShortd(String shortd) {
        this.shortd = shortd;
    }

    @Override
    public String toString() {
        return "news{" + "nid=" + nid + ", udate=" + udate + ", tid=" + tid + ", info=" + info + ", shortd=" + shortd + '}';
    }
    
}
