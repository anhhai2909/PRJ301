/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.timetable;

/**
 *
 * @author anhha
 */
public class timetableDAO extends DBContext {

    public String[] gettimetalbe(String cid,String tt) {
        String[] list = new String[6];
        String sql = "select *from timetable where cID=? and tt=? order by slot asc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, cid);
            st.setString(2, tt);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int s = Integer.parseInt(rs.getString("slot"));
                list[s-1] = rs.getString("suID");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public timetable get1timetalbe(String cID) {
        String sql = "select * from timetable where cID =?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                timetable t = new timetable(rs.getString("tt"), rs.getInt("slot"), rs.getString("suID"), rs.getString("cID"));
                return t;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    public void inserttimetable(timetable t){
        String sql = "insert into timetable values(?,?,?,?)";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, t.getTt());
            st.setInt(2, t.getSlot());
            st.setString(3,t.getSuid());
            st.setString(4,t.getCid());
            st.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    public void updatetimetable(timetable t){
        String sql = "update timetable set tt=?,slot=?,suID=?,cID=?";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, t.getTt());
            st.setInt(2, t.getSlot());
            st.setString(3,t.getSuid());
            st.setString(4,t.getCid());
            st.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    public void deletetimetable(String cID){
        try{
            String sql = "delete from timetable where cID=?";
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1,cID);
            st.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
}
