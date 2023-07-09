/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author anhha
 */
public class bestclasses {
    private String cID;
    private String classname;
    private int numofst;
    private int numofgoodst;
    private int years;

    public bestclasses(String cID, String classname, int numofst, int numofgoodst, int years) {
        this.cID = cID;
        this.classname = classname;
        this.numofst = numofst;
        this.numofgoodst = numofgoodst;
        this.years = years;
    }

    public String getcID() {
        return cID;
    }

    public void setcID(String cID) {
        this.cID = cID;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public int getNumofst() {
        return numofst;
    }

    public void setNumofst(int numofst) {
        this.numofst = numofst;
    }

    public int getNumofgoodst() {
        return numofgoodst;
    }

    public void setNumofgoodst(int numofgoodst) {
        this.numofgoodst = numofgoodst;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    @Override
    public String toString() {
        return "bestclasses{" + "cID=" + cID + ", classname=" + classname + ", numofst=" + numofst + ", numofgoodst=" + numofgoodst + ", years=" + years + '}';
    }
    
    
    
}
