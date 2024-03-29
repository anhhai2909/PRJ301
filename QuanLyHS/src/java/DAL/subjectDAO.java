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

    public ArrayList<subject> getsubjectbygrade(String grade) {
        ArrayList<subject> list = new ArrayList<>();
        String sql = "select * from subject where grade=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, grade);
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

    public ArrayList<String> getsubjectmanaged(String tid) {
        ArrayList<String> list = new ArrayList<>();
        String sql = "select subject.name from subject join subjectmanage on subjectmanage.suID = subject.suID where tID =?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, tid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(rs.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    public ArrayList<String> getsubjectmanagedbytidandsuid(String tid,String suid) {
        ArrayList<String> list = new ArrayList<>();
        String sql = "select subject.name from subject join subjectmanage on subjectmanage.suID = subject.suID where tID =? and subjectmanage.suID=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, tid);
            st.setString(2, suid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(rs.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public String checksubjectmanage(String tid, String suid) {
        String sql = "  select distinct cID from mark join subjectmanage on mark.suID = subjectmanage.suID where subjectmanage.tID =? and subjectmanage.suID=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, tid);
            st.setString(2, suid);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return rs.getString("cID");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public ArrayList<subject> checkexistedsubject(String id, String name, String descript) {
        ArrayList<subject> list = new ArrayList<>();
        String sql = "select * from subject where suID=? or name=? or descript=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, id);
            st.setString(2, name);
            st.setString(3, descript);
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

    public ArrayList<subject> searchsubject(String suid, String name) {
        ArrayList<subject> list = new ArrayList<>();
        String sql = "select * from subject where suID like ? and name like ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "%" + suid + "%");
            st.setString(2, "%" + name + "%");
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

    public ArrayList<subject> getsubjectbyyearandclass(int years, String cid) {
        ArrayList<subject> list = new ArrayList<>();
        String sql = "select distinct subject.suID,name,descript "
                + "from subject join mark on mark.suID = subject.suID join class on class.cID = mark.cID "
                + "where mark.years = ? and mark.cID =?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, years);
            st.setString(2, cid);
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

    public subject get1subjectbygrade(String id, String grade) {
        String sql = "select * from subject where suID=? and grade like ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, id);
            st.setString(2, grade);
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

    public void insertsubject(subject s, String grade) {
        String sql = "insert into subject values(?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, s.getSuid());
            st.setString(2, s.getName());
            st.setString(3, s.getDescript());
            st.setString(4, grade);
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
    
    public void insertsubjectmanage(String tid, String suid) {
        String sql = "insert into subjectmanage values(?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, suid);
            st.setString(2, tid);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public void deletesubjectmanagebytid(String tid) {
        String sql = "delete from subjectmanage where tID =?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, tid);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public void deletesubjectmanage(String tid,String suname) {
        String sql = "delete from subjectmanage where suID =(select suID from subject where name =?) and tID =?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(2, tid);
            st.setString(1, suname);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
