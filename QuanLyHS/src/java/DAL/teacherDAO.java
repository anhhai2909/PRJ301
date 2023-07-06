/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.teacher;

/**
 *
 * @author anhha
 */
public class teacherDAO extends DBContext {

    public ArrayList<teacher> getteacher() {
        ArrayList<teacher> list = new ArrayList<>();
        String sql = "select * from teacher";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                teacher t = new teacher(rs.getString("tID"), rs.getString("name"), rs.getString("email"), rs.getString("imgaddress"));
                list.add(t);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public ArrayList<String> getfreeteacher(int y) {
        ArrayList<String> list = new ArrayList<>();
        String sql = "  select distinct teacher.tID from teacher " +
                        "full outer join classes on classes.tID = teacher.tID " +
                        "where  teacher.tID not in (select classes.tID from classes " +
                        "where years=?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, y);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(rs.getString("tID"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public teacher get1teacherbyyearandid(String id, int years) {
        String sql = "  select * from classes "
                + "  where tID =? and years=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, id);
            st.setInt(2, years);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                teacher t = new teacher(rs.getString("tID"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("imgaddress"));
                return t;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public teacher get1teacher(String id) {
        String sql = "select * from teacher where tID=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                teacher t = new teacher(rs.getString("tID"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("imgaddress"));
                return t;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
}
