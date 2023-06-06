/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;


import DAL.accountDAO;



/**
 *
 * @author anhha
 */
public class test {
    public static void main(String[] args){
        accountDAO a = new accountDAO();
        System.out.println(a.get1account("admin1", "123"));
       
    }
}
