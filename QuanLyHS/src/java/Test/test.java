/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import DAL.StudentDAO;
import DAL.accountDAO;
import DAL.beststudentDAO;
import DAL.classDAO;
import DAL.markDAO;
import DAL.markavgDAO;
import DAL.subjectDAO;
import DAL.teacherDAO;
import java.util.ArrayList;
import model.Student;
import model.bestclasses;
import model.beststudent;
import model.classes;
import model.mark;
import model.markavg;
import model.subject;
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
        StudentDAO d4 = new StudentDAO();
        subjectDAO d5 = new subjectDAO();       
        ArrayList<String> l = d1.getfreeteacher(2018);
        for(int i =0 ; i< l.size();i++){
            System.out.println(l.get(i));
        }
    }
}
