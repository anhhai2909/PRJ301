/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.bestclasses;
import model.classes;
import model.markavg;
import model.years;

/**
 *
 * @author anhha
 */
public class markavgDAO extends DBContext {

    public ArrayList<markavg> getavg(int years,String cid) {
        ArrayList<markavg> list = new ArrayList();
        String sql = "select * from markavg where years=? and cid = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, years);
            st.setString(2, cid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {           
                markavg m = new markavg(rs.getString("sID"), rs.getString("cID"), (double) Math.ceil(rs.getDouble("avgm") * 10) / 10, rs.getInt("years"));
                list.add(m);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
     public markavg get1avg(int years,String sid) {
        String sql = "select * from markavg where years=? and sID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, years);
            st.setString(2, sid);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {           
                markavg m = new markavg(rs.getString("sID"), rs.getString("cID"), (double) Math.ceil(rs.getDouble("avgm") * 10) / 10, rs.getInt("years"));
                return m;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    
    public ArrayList<years> getyears() {
        ArrayList<years> list = new ArrayList();
        String sql = "select distinct years from markavg";
        try {
            PreparedStatement st = connection.prepareStatement(sql);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {           
                years y = new years(rs.getInt("years"));
                list.add(y);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public ArrayList<classes> getclass(int year){
        ArrayList<classes> list = new ArrayList();
        String sql = "select distinct cID from markavg where years = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, year);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {           
                classes c = new classes(rs.getString("cID"),null , 0,null);
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public int getmaxyear() {
        String sql = "select top 1 years from markavg order by years desc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return rs.getInt("years");
            }
        } catch (SQLException e) {
        }
        return 0;
    }

    public ArrayList<bestclasses> getnum() {
        ArrayList<bestclasses> list = new ArrayList<>();
        String sql = "select top 6 markavg.cID,class.classname,class.numberofstudent, count(markavg.avgm) as count,markavg.years\n"
                + "from markavg join class on class.cID = markavg.cID\n"
                + "where (markavg.avgm >=8.0 and markavg.avgm <=10) and  markavg.years=(select max (markavg.years) from markavg)\n"
                + "group by markavg.cID,class.classname,class.numberofstudent,markavg.years\n"
                + "order by count(markavg.avgm) desc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                bestclasses b = new bestclasses(rs.getString("cID"), rs.getString("classname"), rs.getInt("numberofstudent"), rs.getInt("count"), rs.getInt("years"));
                list.add(b);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
}
