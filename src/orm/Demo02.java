package orm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: JDBCTest
 * @Package: orm
 * @ClassName: Demo02
 * @Author: HAND_WEILI
 * @Description: ${description}
 * @Date: 2020/6/6 20:40
 * @Version: 1.0
 */

//使用JAVAbean来进行封装
public class Demo02 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Emp> list = new ArrayList<>();
        try {
            conn=  JDBCUtil.getMysqlConnection();
            ps = conn.prepareStatement("select * from emp ");
            rs = ps.executeQuery();
            while (rs.next()){
                Emp emp = new Emp(rs.getInt(1),rs.getString(2),rs.getDouble(3),rs.getDate(4),rs.getInt(5));
                list.add(emp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(rs,ps,conn);
        }
        for(Emp e:list){
            System.out.println(e.getId()+""+e.getUsername()+""+e.getAge());
        }

    }
}
