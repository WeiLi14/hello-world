package jdbcConnetion;

import java.sql.*;
import java.util.Random;

/**
 * @ProjectName: JDBCTest
 * @Package: jdbcConnetion
 * @ClassName: Demo07
 * @Author: HAND_WEILI
 * @Description: ${description}
 * @Date: 2020/6/4 21:22
 * @Version: 1.0
 */
// 时间类型的 转换 1970年开始进行的
    // 三个子类的重要性
    //java.sql.date 表示年月日
public class Demo07 {
    public static void main(String[] args) {
        Connection conn=null;
        ResultSet rs=null;
        PreparedStatement preparedStatement=null;
        Statement st2=null;


        try {
            Class clazz = Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc?serverTimezone=UTC","root","123456");

            String sql ="INSERT into t_user (username,password,regtime,lastlogtime) values (?,?,?,?)";
            for(int i = 0 ; i < 1000 ; i++) {
                preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setObject(1, "liwei"+i);
                preparedStatement.setObject(2, "123456");
                int random=100000000+new Random().nextInt(1000000000);
                //使用date
                Date date = new Date(System.currentTimeMillis()-random);
                preparedStatement.setObject(3, date);
                //时间戳
                Timestamp timestamp = new Timestamp(System.currentTimeMillis()-random);
                preparedStatement.setObject(4, timestamp);
                preparedStatement.execute();
            }
        } catch (ClassNotFoundException e) {
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }
}
