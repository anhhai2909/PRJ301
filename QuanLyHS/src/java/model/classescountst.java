/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author anhha
 */
public class classescountst {
    private String cid;
    private String name;
    private int numofst;
    private int rating;

    public classescountst(String cid, String name, int numofst, int rating) {
        this.cid = cid;
        this.name = name;
        this.numofst = numofst;
        this.rating = rating;
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
    
    
}
