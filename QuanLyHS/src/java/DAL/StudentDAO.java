/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Student;

/**
 *
 * @author anhha
 */
public class StudentDAO extends DBContext {

    public ArrayList<Student> getStudent() {
        ArrayList<Student> list = new ArrayList<>();
        String sql = "select * from Student order by dob asc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
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
                        rs.getString("cID"));
                list.add(s);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public String getclassbystudentid(String sid, int year) {
        String sql = "select cID from learninghistory where sID=? and years=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, sid);
            st.setInt(2, year);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return rs.getString("cID");
            }
        } catch (SQLException e) {
        }
        return null;
    }

    public ArrayList<Student> getstudentbyclassandyear(String cid, int years) {
        ArrayList<Student> list = new ArrayList<>();
        String sql = "  select Student.sID,Student.name,Student.gender,Student.dob,Student.homeaddress,Student.idnumber,Student.email,Student.phone,Student.prname,Student.prphone,Student.imgaddress,Student.cID "
                + "  from Student join learninghistory on learninghistory.sID = Student.sID "
                + "  where learninghistory.cID = ? and learninghistory.years=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, cid);
            st.setInt(2, years);
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
        return list;
    }

    public boolean checkexiststudentinclass(String id, int y, String cid) {
        String sql = "select * from learninghistory where sID=? and years=? and cID=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, id);
            st.setInt(2, y);
            st.setString(3, cid);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    public ArrayList<Student> searchStudent(String sid, String name) {
        ArrayList<Student> list = new ArrayList<>();
        String sql = " select * from Student where sID like ? and name like ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "%" + sid + "%");
            st.setString(2, "%" + name + "%");
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
                        rs.getString("cID"));
                list.add(s);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public ArrayList<Student> getlistbypage(ArrayList<Student> list, int start, int end) {
        ArrayList<Student> arr = new ArrayList<>();
        for (int i = start; i < end; i++) {
            arr.add(list.get(i));
        }
        return arr;
    }

    public Student get1student(String id) {
        String sql = "select * from Student where sID=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
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
                return s;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public Student checkexiststudentstudent(String id, String email, String phone, String idnum, String prphone) {
        String sql = "select * from Student where sID=? or idnumber=? or email=? or phone=? or prphone=? ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, id);
            st.setString(2, idnum);
            st.setString(3, email);
            st.setString(4, phone);
            st.setString(5, prphone);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
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
                return s;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public Student checkexiststudentstudentupdate(String id, String email, String phone, String idnum, String prphone) {
        String sql = "select * from Student where sID!=? and ( idnumber=? or email=? or phone=? or prphone=? )";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, id);
            st.setString(2, idnum);
            st.setString(3, email);
            st.setString(4, phone);
            st.setString(5, prphone);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
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
                return s;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public void insertstudent(Student s) {
        String sql = "insert into Student values(?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, s.getsID());
            st.setString(2, s.getName());
            st.setInt(3, s.getGender());
            st.setDate(4, s.getDob());
            st.setString(5, s.getHomeaddress());
            st.setString(6, s.getIdnumber());
            st.setString(7, s.getEmail());
            st.setString(8, s.getPhone());
            st.setString(9, s.getPrname());
            st.setString(10, s.getPrphone());
            st.setString(11, s.getImgaddress());
            st.setString(12, s.getcID());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void updatestudent(Student s) {
        String sql = "update Student set name=?,gender=?,dob=?,homeaddress=?,idnumber=?,email=?,phone=?,prname=?,prphone=?,imgaddress=?,cID=? where sID=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, s.getName());
            st.setInt(2, s.getGender());
            st.setDate(3, s.getDob());
            st.setString(4, s.getHomeaddress());
            st.setString(5, s.getIdnumber());
            st.setString(6, s.getEmail());
            st.setString(7, s.getPhone());
            st.setString(8, s.getPrname());
            st.setString(9, s.getPrphone());
            st.setString(10, s.getImgaddress());
            st.setString(11, s.getcID());
            st.setString(12, s.getsID());
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public boolean checkexistlh(String sid,int year){
        String sql = "select * from learninghistory where sID = ? and years=?";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, sid);
            st.setInt(2, year);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                return true;
            }
        }catch(SQLException e){         
        }
        return false;
    }

    public void insertintolearn(Date datein, Date dateout, String sid) {
        String sql = "insert into learn values(?,?,?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setDate(1, datein);
            st.setDate(2, dateout);
            st.setString(3, sid);
            st.executeQuery();
        } catch (SQLException e) {

        }
    }

    public void insertintolearnhistory(String sid, String cid, int year) {
        String sql = " insert into learninghistory values(?,?,?,(select distinct tID from learninghistory where cID =? and years =?))";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, sid);
            st.setString(2, cid);
            st.setInt(3, year);
            st.setString(4, cid);
            st.setInt(5, year);
            st.executeUpdate();
        } catch (SQLException e) {

        }
    }

    public void updatelearnhistory(String sid, String cid, int year) {
        String sql = "update learninghistory set cID=? where sID=? and years=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, cid);
            st.setString(2, sid);
            st.setInt(3, year);
            st.executeUpdate();
        } catch (SQLException e) {

        }
    }

    public void deletelearnhistory(String sid, String cid, int year) {
        String sql = "delete from learninghistory where sID = ? and cID=? and years=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, sid);
            st.setString(2, cid);
            st.setInt(3, year);
            st.executeUpdate();
        } catch (SQLException e) {

        }
    }

    public void updatelearn(Date datein, Date dateout, String sid) {
        String sql = "update learn set begindate=?, enddate = ? where sID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setDate(1, datein);
            st.setDate(2, dateout);
            st.setString(3, sid);
            st.executeQuery();
        } catch (SQLException e) {

        }
    }

    public void deletestudent(String id) {
        String sql = "delete from Student where sID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
     public void deletelearn(String sid) {
        String sql = "delete from learn where sID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, sid);
            st.executeQuery();
        } catch (SQLException e) {

        }
    }
    public void deletelearnhistorybysid(String sid) {
        String sql = "delete from learninghistory where sID = ? ";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, sid);
            st.executeUpdate();
        } catch (SQLException e) {

        }
    }

    
}
