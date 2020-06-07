package orm;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @ProjectName: JDBCTest
 * @Package: jdbcConnetion
 * @ClassName: JDBCUtil
 * @Author: HAND_WEILI
 * @Description: ${description}
 * @Date: 2020/6/6 16:27
 * @Version: 1.0
 */
public class JDBCUtil {
    //读取资源文件 hashtable的子类 properties
    static Properties properties = null;
    // 静态代码块，在加载UTIL类的时候调用一次 ，加载一次 》
    static{
        properties = new Properties();
        //获取资源文件的输入流
        try {
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Connection用于进行获取数据库链接
    public static Connection getMysqlConnection(){
        try {
         Class.forName(properties.getProperty("mysqlDriver"));
         return DriverManager.getConnection(properties.getProperty("mysqlURL"),properties.getProperty("user"),properties.getProperty("password"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // 关闭链接
   public static void close(ResultSet rs, Statement statement,Connection connection){
       try {
           rs.close();
       } catch (SQLException e) {
           e.printStackTrace();
       }
       try {
           statement.close();
       } catch (SQLException e) {
           e.printStackTrace();
       }
       try {
           connection.close();
       } catch (SQLException e) {
           e.printStackTrace();
       }
   }
    public static void close(ResultSet rs, PreparedStatement statement,Connection connection){
        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // 关闭链接
    public static void close(Statement statement,Connection connection){
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // 关闭链接
    public static void close(Connection connection){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
