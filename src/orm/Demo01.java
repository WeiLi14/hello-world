package orm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: JDBCTest
 * @Package: orm
 * @ClassName: Demo01
 * @Author: HAND_WEILI
 * @Description: ${description}
 * @Date: 2020/6/6 17:24
 * @Version: 1.0
 */
// 测试 OBJECT RELATION MAPPING
    // 测试数组封装一个数组封装对象.
public class Demo01 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<Object[]> list = new ArrayList<>();
        try {
            conn=  JDBCUtil.getMysqlConnection();
             ps = conn.prepareStatement("select * from emp ");
           //  ps.setObject(1,1);
             rs = ps.executeQuery();
            // 全部用object数组来搞

             while (rs.next()){
                 //System.out.println(rs.getString(2));
                 Object[]   objs = new Object[5];
                 for(int i = 0 ; i< 5 ;i++){
                     objs[i]=rs.getObject(i+1);
                 }
                 list.add(objs);

             }

        } catch (SQLException e) {
            e.printStackTrace();
    }finally {
            JDBCUtil.close(rs,ps,conn);
        }
        for (Object[] objects:list){
           for (int i =0 ;i<5 ;i++){
               System.out.print(objects[i]);
           }
        }

    }
}
