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
import model.years;

/**
 *
 * @author anhha
 */
public class markavgDAO extends DBContext {

    public ArrayList<markavg> getavgbyyearandcid(int years,String cid) {
        ArrayList<markavg> list = new ArrayList();
        String sql = "select * from markavg where years=? and cid = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, years);
            st.setString(2, cid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {           
                markavg m = new markavg(rs.getString("sID"), rs.getString("cID"), (double) Math.ceil(rs.getDouble("avgm") * 10) / 10, rs.getInt("years"));
                list.add(m);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    public ArrayList<markavg> getavgbysidsnameandyear(String sid,String name,String year) {
        ArrayList<markavg> list = new ArrayList();
        String sql = "select markavg.sID,markavg.cID,markavg.avgm,markavg.years " +
                        "from markavg join Student on Student.sID = markavg.sID " +
                        "where markavg.sID like ? and name like ? and markavg.years like ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "%"+sid+"%");
            st.setString(2, "%"+name+"%");
            st.setString(3, "%"+year+"%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {           
                markavg m = new markavg(rs.getString("sID"), rs.getString("cID"), (double) Math.ceil(rs.getDouble("avgm") * 10) / 10, rs.getInt("years"));
                list.add(m);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
     public markavg get1avg(int years,String sid) {
        String sql = "select * from markavg where years=? and sID = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, years);
            st.setString(2, sid);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {           
                markavg m = new markavg(rs.getString("sID"), rs.getString("cID"), (double) Math.ceil(rs.getDouble("avgm") * 10) / 10, rs.getInt("years"));
                return m;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }   

    public int getmaxyear() {
        String sql = "select top 1 years from markavg order by years desc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return rs.getInt("years");
            }
        } catch (SQLException e) {
        }
        return 0;
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
                bestclasses b = new bestclasses(rs.getString("cID"), rs.getString("classname"), rs.getInt("numberofstudent"), rs.getInt("count"), rs.getInt("years"));
                list.add(b);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
}
