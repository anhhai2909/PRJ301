
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
        accountDAO d = new accountDAO();
        int max=0;
        ArrayList<account> list = d.getaccount();
        for (int i = 0; i < list.size(); i++) {
            if (max < Integer.parseInt(list.get(i).getUser().substring(5, list.get(i).getUser().length()))) {
                max = Integer.parseInt(list.get(i).getUser().substring(5, list.get(i).getUser().length()));
            }
        }
        String username = "admin" + (max + 1);
        System.out.println(username);
    }
}
