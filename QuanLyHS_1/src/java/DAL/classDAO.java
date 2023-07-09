    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.classes;

/**
 *
 * @author anhha
 */
public class classDAO extends DBContext{
    public ArrayList<classes> getclass(){
        ArrayList<classes> list = new ArrayList<>();
        String sql = "select * from class";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                classes c = new classes(rs.getString("cID"), rs.getString("classname"), rs.getInt("numberofstudent"), rs.getString("tID"));
                list.add(c);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return list;
    }
    public classes get1class(String id){
        String sql = "select * from class where cID = ?";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1,id);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                classes c = new classes(rs.getString("cID"), rs.getString("classname"), rs.getInt("numberofstudent"), rs.getString("tID"));
                return c;
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return null;
    }
    public void insertclass(classes c){
        String sql = "insert into class values(?,?,?,?)";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, c.getCid());
            st.setString(2, c.getName());
            st.setInt(3, c.getNumofst());
            st.setString(4,c.getTid());
            st.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    public void updateclass(classes c){
        String sql="update class set cID=?,classname=?,numberofstudent=?,tID=?";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, c.getCid());
            st.setString(2, c.getName());
            st.setInt(3, c.getNumofst());
            st.setString(4,c.getTid());
            st.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    public void deleteclass(String id){
        String sql= "delete from class where cID=?";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1,id);
            st.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
    }
}
