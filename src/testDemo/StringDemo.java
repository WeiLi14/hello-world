package testDemo;

import java.io.UnsupportedEncodingException;

/**
 * @ProjectName: JDBCTest
 * @Package: testDemo
 * @ClassName: StringDemo
 * @Author: HAND_WEILI
 * @Description: ${description}
 * @Date: 2020/6/6 11:02
 * @Version: 1.0
 */
// 该类用于测试如何将 一个字符编码进行修改
public class StringDemo {
    public static void main(String[] args) {
        // 将原字符串修改编码
        String str = new String("GBK");
        str="123456";
        System.out.println(str);
        System.out.println( str.getBytes());
        try {
            String str2 = new String(str.getBytes(),"ISO-8859-1");
            System.out.println(str2);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
