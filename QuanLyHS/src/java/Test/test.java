/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import DAL.StudentDAO;
import java.util.ArrayList;
import model.Student;

/**
 *
 * @author anhha
 */
public class test {
    public static void main(String[] args){
        StudentDAO c = new StudentDAO();
        ArrayList<Student> arr = c.getStudent();
        for(Student i:arr){
            i.toString();
        }
    }
}
