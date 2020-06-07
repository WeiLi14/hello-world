package jdbcConnetion;

import java.sql.*;

/**
 * @ProjectName: JDBCTest
 * @Package: jdbcConnetion
 * @ClassName: Demo04
 * @Author: HAND_WEILI
 * @Description: ${description}
 * @Date: 2020/6/4 20:29
 * @Version: 1.0
 */
// 测试reultset
public class Demo04 {
    public static void main(String[] args) {
        Connection conn=null;
        ResultSet rs=null;
        PreparedStatement ps=null;

        try {
            Class clazz = Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc?serverTimezone=UTC","root","123456");

            String sql ="INSERT into t_user (username,password,regtime) values (?,?,?)";
            String sql2 ="select * from t_user ";

            ps = conn.prepareStatement(sql2);
            // resultset是个结果集
             rs = ps.executeQuery();
            while(rs.next()){
                System.out.println( rs.getObject(1)+" "+rs.getObject(2));
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                rs.close();
                ps.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }

        // 可以全部使用setObject
    }
}
