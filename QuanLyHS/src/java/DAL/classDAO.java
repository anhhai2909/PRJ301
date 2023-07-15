/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Student;
import model.classes;

/**
 *
 * @author anhha
 */
public class classDAO extends DBContext {

    public ArrayList<classes> getpresentclass() {
        ArrayList<classes> list = new ArrayList<>();
        String sql = "select distinct cID,classname,numberofstudent,tID from classes where years = (select distinct top 1 years from classes order by years desc)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                classes c = new classes(rs.getString("cID"), rs.getString("classname"), rs.getInt("numberofstudent"), rs.getString("tID"));
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public ArrayList<classes> getallclass() {
        ArrayList<classes> list = new ArrayList<>();
        String sql = "select distinct cID,classname,numberofstudent,tID from classes";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                classes c = new classes(rs.getString("cID"), rs.getString("classname"), rs.getInt("numberofstudent"), rs.getString("tID"));
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public ArrayList<classes> getclassbyyear(int y) {
        ArrayList<classes> list = new ArrayList<>();
        String sql = "  select * from classes where years = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, y);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                classes c = new classes(rs.getString("cID"), rs.getString("classname"), rs.getInt("numberofstudent"), rs.getString("tID"));
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public classes get1classbycidandyear(String id, int year) {
        String sql = "  select * from classes where cID = ? and years = ? ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, id);
            st.setInt(2, year);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                classes c = new classes(rs.getString("cID"), rs.getString("classname"), rs.getInt("numberofstudent"), rs.getString("tID"));
                return c;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public String getcIDbysidandyear(String id, int year) {
        String sql = "select cID from learninghistory where sID = ? and years = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, id);
            st.setInt(2, year);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return rs.getString("cID");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public String getclassbytidyearandcid(String cid,String tid, String years) {
        String sql = "select cid from classes where tID=? and  cID = ? and years=? ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, tid);
            st.setString(2, cid);
            st.setString(3,years);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return rs.getString("cID");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public int getnumberofstudentbyclass(String cid) {
        ArrayList<Student> list = new ArrayList<>();
        String sql = "select * from Student where cID=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, cid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Student s = new Student(rs.getString("sID"),
                        rs.getString("name"),
                        rs.getInt("gender"),
                        rs.getDate("dob"),
                        rs.getString("homeaddress"),
                        rs.getString("idnumber"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getString("prname"),
                        rs.getString("prphone"),
                        rs.getString("imgaddress"),
                        rs.getString("cID")
                );
                list.add(s);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list.size();
    }

    public void updatenumberofstudent(String cid, int years) {
        int num = 0;
        String sql = "select sID from learninghistory where cID=? and years=?";
        String sql2 = "update classes set numberofstudent = ? where cID =? and years=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            PreparedStatement st2 = connection.prepareStatement(sql2);
            st.setString(1, cid);
            st.setInt(2, years);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                num++;
            }
            st2.setInt(1, num);
            st2.setString(2, cid);
            st2.setInt(3, years);
            st2.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void insertclass(classes c) {
        String sql = "insert into class values(?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, c.getCid());
            st.setString(2, c.getName());
            st.setInt(3, c.getNumofst());
            st.setString(4, c.getTid());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void insertclasstoclasshistory(classes c, int years) {
        String sql = "insert into classes values(?,?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, c.getCid());
            st.setString(2, c.getName());
            st.setInt(3, c.getNumofst());
            st.setString(4, c.getTid());
            st.setInt(5, years);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void updateclass(String name, String tid, String cid, int years) {
        String sql = "update classes set classname=?, tID=? where cid=? and years=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            st.setString(2, tid);
            st.setString(3, cid);
            st.setInt(4, years);

            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void deleteclass(String id) {
        String sql = "delete from class where cID=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void deleteclasshistory(String id, int years) {
        String sql = "delete from classes where cID=? and years=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, id);
            st.setInt(2, years);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

}
