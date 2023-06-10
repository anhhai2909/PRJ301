/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import DAL.accountDAO;
import DAL.beststudentDAO;
import DAL.markavgDAO;
import java.util.ArrayList;
import model.bestclasses;
import model.beststudent;

/**
 *
 * @author anhha
 */
public class test {

    public static void main(String[] args) {
        markavgDAO d = new markavgDAO();
        ArrayList<bestclasses> l = d.getnum();
        for (bestclasses i : l) {
            System.out.println(i.toString());
        }

    }
}
