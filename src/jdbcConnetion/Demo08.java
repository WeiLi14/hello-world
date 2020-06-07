package jdbcConnetion;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;

/**
 * @ProjectName: JDBCTest
 * @Package: jdbcConnetion
 * @ClassName: Demo08
 * @Author: HAND_WEILI
 * @Description: ${description}
 * @Date: 2020/6/6 14:34
 * @Version: 1.0
 */

//测试取出指定日期的数据
public class Demo08 {

    public static long strParseTime(String time){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            return dateFormat.parse(time).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }

    }
    public static void main(String[] args) {
        Connection conn=null;
        ResultSet rs=null;
        PreparedStatement preparedStatement=null;
        Statement st2=null;


        try {
            Class clazz = Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc?serverTimezone=UTC","root","123456");

            String sql ="select * from t_user where regTime>? and regTime<?";
            preparedStatement = conn.prepareStatement(sql);
            java.sql.Date start = new Date(strParseTime("2020-05-29 10:12:22"));
            java.sql.Date end = new Date(strParseTime("2020-06-03 22:12:22"));
            System.out.println(start);
            System.out.println(end);

            preparedStatement.setObject(1,start);
            preparedStatement.setObject(2,end);

            rs =preparedStatement.executeQuery();
            int i =0;
            while (rs.next()){
                i++;
                System.out.println(rs.getInt("id")+""+rs.getObject("username")+""+rs.getDate("regtime"));
            }
            System.out.println(i);


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
