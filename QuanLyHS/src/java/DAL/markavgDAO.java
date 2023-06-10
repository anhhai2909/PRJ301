/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.bestclasses;
import model.markavg;

/**
 *
 * @author anhha
 */
public class markavgDAO extends DBContext {

    public ArrayList<markavg> getavg(int years) {
        ArrayList<markavg> list = new ArrayList();
        String sql = "select * from markavg where years=?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, years);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                markavg m = new markavg(rs.getString("sID"), rs.getString("cID"), rs.getDouble("avgm"), rs.getInt("years"));
                list.add(m);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public ArrayList<bestclasses> getnum() {
        ArrayList<bestclasses> list = new ArrayList<>();
        String sql = "select top 6 markavg.cID,class.classname,class.numberofstudent, count(markavg.avgm) as count,markavg.years\n"
                + "from markavg join class on class.cID = markavg.cID\n"
                + "where (markavg.avgm >=8.0 and markavg.avgm <=10) and  markavg.years=(select max (markavg.years) from markavg)\n"
                + "group by markavg.cID,class.classname,class.numberofstudent,markavg.years\n"
                + "order by count(markavg.avgm) desc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                bestclasses b = new bestclasses(rs.getString("cID"), rs.getString("classname"),rs.getInt("numberofstudent"),rs.getInt("count"),rs.getInt("years"));
                list.add(b);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
}
