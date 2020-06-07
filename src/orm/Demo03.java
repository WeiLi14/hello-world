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
 * @ClassName: Demo03
 * @Author: HAND_WEILI
 * @Description: ${description}
 * @Date: 2020/6/6 20:24
 * @Version: 1.0
 */
public class Demo03 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Map<String,Object> row = new HashMap<>();
       List< Map<String,Object> > list2 = new ArrayList<>();
        List<Object[]> list = new ArrayList<>();
        try {
            conn=  JDBCUtil.getMysqlConnection();
            ps = conn.prepareStatement("select * from emp where id =1 ");
            //  ps.setObject(1,1);
            rs = ps.executeQuery();
            // 全部用object数组来搞

            while (rs.next()){
                //System.out.println(rs.getString(2));
           /*     Object[]   objs = new Object[5];
                for(int i = 0 ; i< 5 ;i++){
                    objs[i]=rs.getObject(i+1);
                }
                list.add(objs);
*/
                //用map放
                row.put("id",rs.getObject(1));
                row.put("empname",rs.getObject(2));
                row.put("salary",rs.getObject(3));
                row.put("brithday",rs.getObject(4));
                row.put("age",rs.getObject(5));
                list2.add(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(rs,ps,conn);
        }
        for (String key:row.keySet()){
            System.out.println(key+""+row.get(key));
        }

    }
}
