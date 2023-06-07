/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author anhha
 */
public class beststudent {
    private String sid;
    private String name;
    private String classname;
    private double avg;
    private int years;

    public beststudent(String sid, String name, String classname, double avg, int years) {
        this.sid = sid;
        this.name = name;
        this.classname = classname;
        this.avg = avg;
        this.years = years;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
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
        return "beststudent{" + "sid=" + sid + ", name=" + name + ", classname=" + classname + ", avg=" + avg + ", years=" + years + '}';
    }
    
    
}
