
import DAL.subjectDAO;
import DAL.yearsDAO;
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
        subjectDAO d = new subjectDAO();
        yearsDAO d2 = new yearsDAO();
        System.out.println(d2.getpresentyear());
    }
}
