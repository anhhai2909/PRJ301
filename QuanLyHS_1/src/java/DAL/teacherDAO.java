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
public class teacherDAO extends DBContext{
    public ArrayList<teacher> getteacher(){
        ArrayList<teacher> list = new ArrayList<>();
        String sql="select * from teacher";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                teacher t = new teacher(rs.getString("tID"),rs.getString("name"),rs.getString("email"),rs.getInt("position"),rs.getString("imgaddress"));
                list.add(t);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return list;
    }
    public teacher get1teacher(String id){
        String sql ="select * from teacher where tID=?";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1,id);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                teacher t = new teacher(rs.getString("tID"),
                                        rs.getString("name"),
                                        rs.getString("email"),
                                        rs.getInt("position"),
                                        rs.getString("imgaddress"));
                return t;
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return null;
    }
}
