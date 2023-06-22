/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.beststudent;

/**
 *
 * @author anhha
 */
public class beststudentDAO extends DBContext {

    public ArrayList<beststudent> getbst() {
        ArrayList<beststudent> list = new ArrayList<>();
        String sql =   "select * from( \n"
  +     "select top 2 Student.sID,Student.name,class.classname,avg(mark.avag) as avga,mark.years\n"
  +     "from Student join class on Student.cID = class.cID join mark on mark.sID = Student.sID\n"
  +     "where mark.years= 2019 and class.classname like'12%'\n"
  +     "group by Student.sID,Student.name,class.classname,mark.years \n"
  +     "order by avga desc) as table1\n"
  +     "union \n"
  +     "select* from\n"
  +     "(select top 2 Student.sID,Student.name,class.classname,avg(mark.avag) as avga,mark.years\n"
  +     "from Student join class on Student.cID = class.cID join mark on mark.sID = Student.sID\n"
  +     "where mark.years= 2019 and class.classname like'11%'\n"
  +     "group by Student.sID,Student.name,class.classname,mark.years\n"
  +     "order by avga desc) as table2\n"
  +     "union\n"
  +     "select * from\n"
  +     "(select top 2 Student.sID,Student.name,class.classname,avg(mark.avag) as avga,mark.years\n"
  +     "from Student join class on Student.cID = class.cID join mark on mark.sID = Student.sID\n"
  +     "where mark.years= 2019 and class.classname like'10%'\n"
  +     "group by Student.sID,Student.name,class.classname,mark.years\n"
  +     "order by avga desc) as table3;\n";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                beststudent bs = new beststudent(rs.getString("sID"), rs.getString("name"), rs.getString("classname"), rs.getDouble("avga"), rs.getInt("years"));
                list.add(bs);
            }
            
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
}
