/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.news;

/**
 *
 * @author anhha
 */
public class newsDAO extends DBContext{
    public ArrayList<news> getnews(){
        ArrayList<news> list = new ArrayList<>();
        String sql = "select * from new";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                news s = new news(rs.getInt("nID"),rs.getDate("udate"),rs.getString("tID"),rs.getString("newinfo"),rs.getString("shortinfp"));           
                list.add(s);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return list;
    }
    public news get1news(int id){
        String sql="select * from new where nID=?";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs= st.executeQuery();
            if(rs.next()){
                news n = new news();
                n.setNid(rs.getInt("nID"));
                n.setUdate(rs.getDate("udate"));
                n.setTid(rs.getString("tID"));
                n.setInfo(rs.getString("newinfo"));
                n.setShortd(rs.getString("shortinfp"));
                return n;
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return null;
    }
    
    public void insertnew(news n){
        String sql="insert into new values(?,?,?,?,?)";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, n.getNid());
            st.setDate(2, n.getUdate());
            st.setString(3, n.getTid());
            st.setString(4,n.getInfo());
            st.setString(5, n.getShortd());
            st.executeUpdate();
        } catch (SQLException e){
            System.out.println(e);
        }
    }
    
    
}
