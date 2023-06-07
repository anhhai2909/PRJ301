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

/**
 *
 * @author anhha
 */
public class StudentDAO extends DBContext{
    
    public ArrayList<Student> getStudent() {
        ArrayList<Student> list = new ArrayList<>();
        String sql = "select * from Student";
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
    
    public Student get1student(String id){
        String sql = "select * from Student where sID=?";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, id);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
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
        }catch(SQLException e){
            System.out.println(e);
        }
        return null;
    }
    public void insertstudent(Student s){
        String sql = "insert into Student values(?,?,?,?,?,?,?,?,?,?,?,?)";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1,s.getsID());
            st.setString(2,s.getName());
            st.setInt(3,s.getGender());
            st.setDate(4, s.getDob());
            st.setString(5, s.getHomeaddress());
            st.setString(6, s.getIdnumber());
            st.setString(7, s.getEmail());
            st.setString(8, s.getPhone());
            st.setString(9,s.getPrname());
            st.setString(10, s.getPrphone());
            st.setString(11, s.getImgaddress());
            st.setString(12, s.getcID());
            st.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    public void updatestudent(Student s){
        String sql = "update Student set name=?,gender=?,dob=?,homeaddress=?,idnumber=?,email=?,phone=?,prname=?,prphone=?,imgaddress=?,cID=? where sID=?";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1,s.getName());
            st.setInt(2, s.getGender());
            st.setDate(3, s.getDob());
            st.setString(4,s.getHomeaddress());
            st.setString(5,s.getIdnumber());
            st.setString(6, s.getEmail());
            st.setString(7, s.getPhone());
            st.setString(8, s.getPrname());
            st.setString(9, s.getPrphone());
            st.setString(10, s.getImgaddress());
            st.setString(11, s.getcID());
            st.setString(12, s.getsID());
            st.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    public void deletestudent(String id){
        String sql = "delete from Student where sID = ?";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1,id);
            st.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
}
