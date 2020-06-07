package jdbcConnetion;

import java.sql.*;

/**
 * @ProjectName: JDBCTest
 * @Package: jdbcConnetion
 * @ClassName: Demo03
 * @Author: HAND_WEILI
 * @Description: ${description}
 * @Date: 2020/6/4 20:08
 * @Version: 1.0
 */
public class Demo03 {
    public static void main(String[] args) {
        try {
            Class clazz = Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc?serverTimezone=UTC","root","123456");
            String sql ="INSERT into t_user (username,password,regtime) values (?,?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);
            // 可以全部使用setObject
            ps.setString(1,"sdf54asf");
            ps.setString(2,"13456");
            ps.setDate(3,new Date(System.currentTimeMillis()));
            ps.execute();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
