/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author anhha
 */
public class learntime {

    private String sid;
    private Date datein;
    private Date dateout;

    public learntime() {
    }

    public learntime(String sid, Date datein, Date dateout) {
        this.sid = sid;
        this.datein = datein;
        this.dateout = dateout;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public Date getDatein() {
        return datein;
    }

    public String getformatDatein() {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String d = df.format(datein);
        return d;
    }

    public void setDatein(Date datein) {
        this.datein = datein;
    }

    public Date getDateout() {
        return dateout;
    }

    public String getformatDateout() {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String d = df.format(dateout);
        return d;
    }

    public void setDateout(Date dateout) {
        this.dateout = dateout;
    }

}
