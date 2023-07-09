/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.learntime;

/**
 *
 * @author anhha
 */
public class learntimeDAO extends DBContext{
    public learntime get1lt(String sid){
        String sql = "select * from learn where sID = ?";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1,sid);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                learntime c = new learntime(rs.getString("sID"), rs.getDate("begindate"), rs.getDate("enddate"));
                return c;
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return null;
    }
    public void insertlt(learntime lt){
        String sql = "insert into learn values(?,?,?)";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setDate(1, lt.getDatein());
            st.setDate(2, lt.getDateout());
            st.setString(3, lt.getSid());
            st.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    public void updatelt(learntime lt){
        String sql="update learn set begindate=?,enddate=? where sID =?";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(3, lt.getSid());
            st.setDate(1, lt.getDatein());
            st.setDate(2, lt.getDateout());
            st.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    public void deletelt(String sid){
        String sql= "delete from learn where sID=?";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1,sid);
            st.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
}
