package jdbcConnetion;

import java.sql.*;

/**
 * @ProjectName: JDBCTest
 * @Package: jdbcConnetion
 * @ClassName: Demo02
 * @Author: HAND_WEILI
 * @Description: ${description}
 * @Date: 2020/6/4 16:43
 * @Version: 1.0
 */
public class Demo02 {
    public static void main(String[] args) {
        try {
            Class clazz = Class.forName("com.mysql.jdbc.Driver");
            // 需要添加这个东西 serverTimezone=UT
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc?serverTimezone=UTC","root","123456");
            // 调用statement
            Statement statement = conn.createStatement();
            String sql = "select * from t_user";
            String sql1 = "delete from t_user where id=1";
            String sql2 = "INSERT into t_user (username,password,regtime) values ('3dfdsd32','1234',NOW())";
            boolean result =statement.execute(sql2);
            // statement用的非常的少 ，并且容易造成sql注入.  例如 or 1=1


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
