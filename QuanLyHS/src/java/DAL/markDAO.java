/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.mark;
import model.years;

/**
 *
 * @author anhha
 */
public class markDAO extends DBContext {

    public ArrayList<mark> getmark() {
        ArrayList<mark> list = new ArrayList<>();
        String sql = "select * from mark";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                mark m = new mark(rs.getDouble("m1"), rs.getDouble("m2"), rs.getDouble("pt1"), rs.getDouble("pt2"), rs.getDouble("mt"), rs.getDouble("fe"), rs.getDouble("avag"), rs.getString("suID"), rs.getString("sID"), rs.getInt("years"));
                list.add(m);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public ArrayList<mark> getmarkbycidandsuidandyear(String cid, String suid, int years) {
        ArrayList<mark> list = new ArrayList<>();
        String sql = "select mark.sID,suID,years,m1,m2,pt1,pt2,mt,fe,avag from mark "
                + "where cID = ? and years = ? and suID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, cid);
            st.setInt(2, years);
            st.setString(3, suid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                mark m = new mark(rs.getDouble("m1"), rs.getDouble("m2"), rs.getDouble("pt1"), rs.getDouble("pt2"), rs.getDouble("mt"), rs.getDouble("fe"), rs.getDouble("avag"), rs.getString("suID"), rs.getString("sID"), rs.getInt("years"));
                list.add(m);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public ArrayList<mark> getmark_by_sid_sname_suid_years(String sid, String name, String suid, String y) {
        ArrayList<mark> list = new ArrayList<>();
        String sql = "select * from mark "
                + "join Student on mark.sID = Student.sID "
                + "where mark.sID like ? and name like ? and suID like ? and years like ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "%" + sid + "%");
            st.setString(2, "%" + name + "%");
            st.setString(3, "%" + suid + "%");
            st.setString(4, "%" + y + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                mark m = new mark(rs.getDouble("m1"), rs.getDouble("m2"), rs.getDouble("pt1"), rs.getDouble("pt2"), rs.getDouble("mt"), rs.getDouble("fe"), rs.getDouble("avag"), rs.getString("suID"), rs.getString("sID"), rs.getInt("years"));
                list.add(m);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public ArrayList<mark> getlistbypage(ArrayList<mark> list, int start, int end) {
        ArrayList<mark> arr = new ArrayList<>();
        for (int i = start; i < end; i++) {
            arr.add(list.get(i));
        }
        return arr;
    }

    public mark get1mark(String sid, String suid, int year) {
        String sql = "select * from mark where sID=? and suID=? and years=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, sid);
            st.setString(2, suid);
            st.setInt(3, year);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                mark m = new mark(rs.getDouble("m1"), rs.getDouble("m2"), rs.getDouble("pt1"), rs.getDouble("pt2"), rs.getDouble("mt"), rs.getDouble("fe"), rs.getDouble("avag"), rs.getString("suID"), rs.getString("sID"), rs.getInt("years"));
                return m;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    
    public void updatecidbysidandyearsandsuid(String cid,String suid,String sid,int years){
        String sql = "update mark set cID=? where suID=? and sID=? and years=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, cid);
            st.setString(2, suid);
            st.setString(3, sid);
            st.setInt(4, years);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public void updatemark(mark m) {
        String sql = "update mark set m1=?,m2=?,pt1=?,pt2=?,mt=?,fe=?,avag=? where suID=? and sID=? and years=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setDouble(1, m.getM1());
            st.setDouble(2, m.getM2());
            st.setDouble(3, m.getPt1());
            st.setDouble(4, m.getPt2());
            st.setDouble(5, m.getMt());
            st.setDouble(6, m.getFe());
            st.setDouble(7, m.getAvag());
            st.setString(8, m.getSuid());
            st.setString(9, m.getSid());
            st.setInt(10, m.getYears());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public void insertmark(mark m,String cid) {
        String sql = "insert into mark values(?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setDouble(1, m.getM1());
            st.setDouble(2, m.getM2());
            st.setDouble(3, m.getPt1());
            st.setDouble(4, m.getPt2());
            st.setDouble(5, m.getMt());
            st.setDouble(6, m.getFe());
            st.setDouble(7, m.getAvag());          
            st.setString(8, m.getSuid());
            st.setString(9, m.getSid());
            st.setInt(10, m.getYears());
            st.setString(11, cid);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void deletemark(String suID, String sid, int years) {
        String sql = "delete from mark where suID=?,sID=?,years=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, suID);
            st.setString(2, sid);
            st.setInt(3, years);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
     public void deletemarkbysid( String sid) {
        String sql = "delete from mark where sID=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, sid);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

}
