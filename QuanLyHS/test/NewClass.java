
import DAL.StudentDAO;
import DAL.accountDAO;
import DAL.subjectDAO;
import DAL.teacherDAO;
import DAL.yearsDAO;
import java.util.ArrayList;
import model.Student;
import model.account;
import model.subject;
import model.teacher;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author anhha
 */
public class NewClass {

    public static void main(String[] args) {
        teacherDAO d = new teacherDAO();
        int max=0;
        d.deleteteacher("GV011");
        subjectDAO d1= new subjectDAO();
        d1.deletesubjectmanage("GV01","Toán 10");
     }
}
