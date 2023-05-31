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
        String sql = "select * from hocsinh";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Student c = new Student(rs.getString("MaHS"),
                        rs.getString("Ten"),
                        rs.getInt("GioiTinh"),
                        rs.getDate("NgaySinh"),
                        rs.getString("QueQuan"),
                        rs.getString("SoCCCD"),
                        rs.getString("SDT"),
                        rs.getString("Email"),
                        rs.getString("TenPH"),
                        rs.getString("SDTPH"),
                        rs.getString("Malop"),
                        rs.getString("MaGV"));
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
}
