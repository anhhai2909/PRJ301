/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.account;

/**
 *
 * @author anhha
 */
public class accountDAO extends DBContext{
    public String get1account(String u, String p){
        String sql = "select * from adminacc where username=? and upassword=?";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, u);
            st.setString(2, p);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                return rs.getString("tID");
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return null;
    }
    public ArrayList<account> getaccount(){
        ArrayList<account> list = new ArrayList<>();
        String sql = "select * from adminacc";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                account a = new account(rs.getString("username"), rs.getString("upassword"), rs.getString("tID"));
                list.add(a);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return list;
    }
    
    public ArrayList<account> getaccount2(){
        ArrayList<account> list = new ArrayList<>();
        String sql = "select * from adminacc where tID !='GV010' order by tID";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                account a = new account(rs.getString("username"), rs.getString("upassword"), rs.getString("tID"));
                list.add(a);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return list;
    }
    public account getaccountbytid(String id){
        String sql = "select * from adminacc where tID=?";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();           
            if(rs.next()){
                account a = new account(rs.getString("username"), rs.getString("upassword"), id);
                return a;
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return null;
    }
    
    public void editacc(String p,String tid){
        String sql = "update adminacc set upassword=? where tID=?";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1,p);
            st.setString(2,tid);
            st.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public void insertacc(String u,String p,String id,String role){
        String sql = "insert into adminacc values(?,?,?,?);";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1,u);
            st.setString(2,p);
            st.setString(3,id);
            st.setString(4,role);
            st.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    public void deleteacc(String u){
        String sql="delete from adminacc where username = ?";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, u);
            st.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
}
