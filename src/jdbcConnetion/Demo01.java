package jdbcConnetion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @ProjectName: JDBCTest
 * @Package: jdbcConnetion
 * @ClassName: Demo01
 * @Author: HAND_WEILI
 * @Description: ${description}
 * @Date: 2020/6/4 16:00
 * @Version: 1.0
 */
public class Demo01 {
    public static void main(String[] args)  {
        try {
            Class clazz = Class.forName("com.mysql.jdbc.Driver");
            long start  = System.currentTimeMillis();
            // 需要添加这个东西 serverTimezone=UTC
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc?serverTimezone=UTC","root","123456");
            long end  = System.currentTimeMillis();
            System.out.println(end-start );

            System.out.println(conn);

            //其实就是一个socket一个连接器，。其实是网络链接进行了两个机器的交互
            // 里面是一个有个socket对象的 。该操作非常耗费时间 。

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
