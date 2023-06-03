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
public class Student {
    private String sID;
    private String name;
    private int gender;
    private Date dob;
    private String homeaddress;
    private String idnumber;
    private String email;
    private String phone;
    private String prname;
    private String prphone;
    private String imgaddress;
    private String cID;

    public Student(String sID, String name, int gender, Date dob, String homeaddress, String idnumber, String email, String phone, String prname, String prphone, String imgaddress, String cID) {
        this.sID = sID;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.homeaddress = homeaddress;
        this.idnumber = idnumber;
        this.email = email;
        this.phone = phone;
        this.prname = prname;
        this.prphone = prphone;
        this.imgaddress = imgaddress;
        this.cID = cID;
    }

    public String getsID() {
        return sID;
    }

    public void setsID(String sID) {
        this.sID = sID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getHomeaddress() {
        return homeaddress;
    }

    public void setHomeaddress(String homeaddress) {
        this.homeaddress = homeaddress;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPrname() {
        return prname;
    }

    public void setPrname(String prname) {
        this.prname = prname;
    }

    public String getPrphone() {
        return prphone;
    }

    public void setPrphone(String prphone) {
        this.prphone = prphone;
    }

    public String getImgaddress() {
        return imgaddress;
    }

    public void setImgaddress(String imgaddress) {
        this.imgaddress = imgaddress;
    }

    public String getcID() {
        return cID;
    }

    public void setcID(String cID) {
        this.cID = cID;
    }
    
  
}
