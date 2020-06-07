package jdbcConnetion;

import java.io.*;
import java.sql.*;

/**
 * @ProjectName: JDBCTest
 * @Package: jdbcConnetion
 * @ClassName: Demo09
 * @Author: HAND_WEILI
 * @Description: ${description}
 * @Date: 2020/6/6 15:25
 * @Version: 1.0
 */
// clob character large object  大数据 ，流数据方式来处理
    // tinytest  255
    // test 65545
    //maeiumtext 1677251
    // 测试 clob
public class Demo09 {
    public static void main(String[] args) {
        Connection conn=null;
        ResultSet rs=null;
        PreparedStatement preparedStatement=null;
        Statement st2=null;


        try {
            Class clazz = Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc?serverTimezone=UTC","root","123456");

            String sql =" INSERT into t_user (username,myinfo) values (?,?)";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setObject(1,"liwei");
            //将文本文件类容直接输入到数据库中，还可以读
            preparedStatement.setClob(2,new FileReader(new File("E:/a.txt")));

            preparedStatement.execute();
            String sql2 =" select * from t_user where id=1002";

            // 如何取出来
            preparedStatement = conn.prepareStatement(sql2);
            rs =preparedStatement.executeQuery();
            while (rs.next()){
                Clob clob = rs.getClob("myinfo");
                // 获取一个字符流
                Reader reader = clob.getCharacterStream();
                int temp = 0 ;
                while((temp=reader.read())!=-1){
                    System.out.print((char) temp);
                }
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
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
