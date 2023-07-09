/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.years;

/**
 *
 * @author anhha
 */
public class yearsDAO extends DBContext {

    public ArrayList<years> getyear() {
        ArrayList<years> list = new ArrayList();
        String sql = "select distinct years from classes";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                years y = new years(rs.getInt("years"));
                list.add(y);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public int getpresentyear() {
        String sql = "select top 1 years from classes order by years desc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                return rs.getInt("years");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }
}
