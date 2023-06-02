/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import DAL.newsDAO;
import java.util.ArrayList;
import model.news;

/**
 *
 * @author anhha
 */
public class test {
    public static void main(String[] args){
        newsDAO c = new newsDAO();
        ArrayList<news> arr = c.getnews();
        System.out.println(arr.get(5).getInfo());
        
        System.out.println(c.get1news(1));
    }
}
