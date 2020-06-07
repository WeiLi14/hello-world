package jdbcConnetion;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.sql.*;

/**
 * @ProjectName: JDBCTest
 * @Package: jdbcConnetion
 * @ClassName: Demo05
 * @Author: HAND_WEILI
 * @Description: ${description}
 * @Date: 2020/6/4 20:44
 * @Version: 1.0
 */

// jdbc批处理 需要插入大量数据时可以提高我们的效率 。
public class Demo05 {
    public static void main(String[] args) {
        Connection conn=null;
        ResultSet rs=null;
        Statement ps=null;
        try {
            // 此处为加载包？
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc?serverTimezone=UTC","root","123456");
            //开启事务
            conn.setAutoCommit(false);
            ps=conn.createStatement();

            //批量创建2w条数据
            for(int i= 0 ; i < 2000 ; i++) {
                ps.addBatch("INSERT into t_user (username,password,regtime) values ('li"+i+"','666666',now())");
            }
            long start = System.currentTimeMillis();
            ps.executeBatch();
            conn.commit();
            long end =System.currentTimeMillis();
            System.out.println("2000条"+(end-start));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //灵活指定就用 preparedStatement
        //存储过程就
    }
}
