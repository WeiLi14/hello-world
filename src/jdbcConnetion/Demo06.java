package jdbcConnetion;

import java.sql.*;

/**
 * @ProjectName: JDBCTest
 * @Package: jdbcConnetion
 * @ClassName: Demo06
 * @Author: HAND_WEILI
 * @Description: ${description}
 * @Date: 2020/6/4 21:09
 * @Version: 1.0
 */

//测试事务
public class Demo06 {
    public static void main(String[] args) {
        Connection conn=null;
        ResultSet rs=null;
        Statement st=null;
        Statement st2=null;


        try {
            Class clazz = Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc?serverTimezone=UTC","root","123456");
            //默认自动提交
            conn.setAutoCommit(false);
            String sql ="INSERT into t_user (username,password,regtime) values ('3dfdsd32','1234',NOW())";
            String sql2 ="select * from t_usersdfsdf ";
            st= conn.createStatement();
            st.execute(sql);
            System.out.println("插入一个用户");
            Thread.sleep(6000);
            st2= conn.createStatement();
            // 导致失败，判断事务。
            st.execute(sql);
            //最后手动提交
            conn.commit();
        } catch (ClassNotFoundException e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
