/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import DAL.accountDAO;
import DAL.beststudentDAO;
import DAL.classDAO;
import DAL.markavgDAO;
import DAL.teacherDAO;
import java.util.ArrayList;
import model.bestclasses;
import model.beststudent;
import model.classes;
import model.markavg;
import model.teacher;

/**
 *
 * @author anhha
 */
public class test {

    public static void main(String[] args) {
        markavgDAO d = new markavgDAO();
        teacherDAO d1 = new teacherDAO();
        classDAO d2 = new classDAO();
        ArrayList<markavg> l = d.getavg(2019,"10a1");
        for (markavg i : l) {
            System.out.println(d.getmaxyear());
        }

    }
}
