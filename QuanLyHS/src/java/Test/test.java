/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import DAL.accountDAO;
import DAL.beststudentDAO;
import java.util.ArrayList;
import model.beststudent;

/**
 *
 * @author anhha
 */
public class test {

    public static void main(String[] args) {
        beststudentDAO d = new beststudentDAO();
        ArrayList<beststudent> l = d.getbst();
        for (beststudent i : l) {
            System.out.println(i.toString());
        }

    }
}
