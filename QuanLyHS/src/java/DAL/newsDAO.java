/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.news;

/**
 *
 * @author anhha
 */
public class newsDAO extends DBContext{
    public ArrayList<news> getnews(){
        ArrayList<news> list = new ArrayList<>();
        String sql = "select * from new";
        try{
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                news s = new news(rs.getString("nID"),rs.getDate("udate"),rs.getString("tID"),rs.getString("newinfo"),rs.getString("shortinfp"));           
                list.add(s);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return list;
    }
}
