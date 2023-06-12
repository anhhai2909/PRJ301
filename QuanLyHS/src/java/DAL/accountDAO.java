/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    
    public void editacc(String nu,String u,String p){
        String sql = "update adminacc set username=?,upassword=? where username=?";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1,u);
            st.setString(2,p);
            st.setString(3,nu);
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
