
import DAL.StudentDAO;
import DAL.subjectDAO;
import DAL.yearsDAO;
import java.util.ArrayList;
import model.Student;
import model.subject;

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
        StudentDAO d = new StudentDAO();
        ArrayList<Student> list = d.getStudent();
            int maxid =0;
            for(int i =0;i< list.size();i++){
                if(maxid < Integer.parseInt(list.get(i).getsID().substring(3, list.get(i).getsID().length()))){
                    maxid =  Integer.parseInt(list.get(i).getsID().substring(3, list.get(i).getsID().length()));
                }
            }            
            String sid = "st0"+(maxid+1);
            
            System.out.println(sid);
    }
}
