package jdbcConnetion;

import orm.JDBCUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * @ProjectName: JDBCTest
 * @Package: jdbcConnetion
 * @ClassName: Demo10
 * @Author: HAND_WEILI
 * @Description: ${description}
 * @Date: 2020/6/6 16:42
 * @Version: 1.0
 */
// 测试使用JDBC工具类，简化JDBC开发
public class Demo10 {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet rs =null;
        connection= JDBCUtil.getMysqlConnection();

        String sql ="INSERT into t_user (username,password,regtime) values ('3dfdsd32','1234',NOW())";
        String sql2 ="select * from t_usersdfsdf ";
        try {
            statement= connection.createStatement();
            statement.execute(sql);


        } catch (SQLException e) {
            e.printStackTrace();
        }

        JDBCUtil.close( statement,connection);

    }
}
