/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author anhha
 */
public class teacher {
    private String tid;
    private String name;
    private String email;
    private String imgaddress;

    public teacher() {
    }

    
    public teacher(String tid, String name, String email, String imgaddress) {
        this.tid = tid;
        this.name = name;
        this.email = email;
        this.imgaddress = imgaddress;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImgaddress() {
        return imgaddress;
    }

    public void setImgaddress(String imgaddress) {
        this.imgaddress = imgaddress;
    }

    @Override
    public String toString() {
        return "teacher{" + "tid=" + tid + ", name=" + name + ", email=" + email + ", imgaddress=" + imgaddress + '}';
    }
    
    
}
