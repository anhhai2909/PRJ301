/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.subject;

/**
 *
 * @author anhha
 */
public class subjectDAO extends DBContext {

    public ArrayList<subject> getsubject() {
        ArrayList<subject> list = new ArrayList<>();
        String sql = "select * from subject";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                subject s = new subject(rs.getString("suID"), rs.getString("name"), rs.getString("descript"));
                list.add(s);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public subject get1subject(String id) {
        String sql = "select * from subject where suID=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                subject s = new subject(rs.getString("suID"), rs.getString("name"), rs.getString("descript"));
                return s;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public void insertsubject(subject s) {
        String sql = "insert into subject values(?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, s.getSuid());
            st.setString(2, s.getName());
            st.setString(3, s.getDescript());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void updatesubject(subject s) {
        String sql = "update subject set suID=?,name=?,descript=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, s.getSuid());
            st.setString(2, s.getName());
            st.setString(3, s.getDescript());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void deletesubject(String id) {
        String sql = "delete from subject where suID=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
