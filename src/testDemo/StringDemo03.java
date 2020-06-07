package testDemo;

/**
 * @ProjectName: JDBCTest
 * @Package: testDemo
 * @ClassName: StringDemo03
 * @Author: HAND_WEILI
 * @Description: ${description}
 * @Date: 2020/6/6 11:21
 * @Version: 1.0
 */
// 该类用于测试如何将字符型转换成数字型
public class StringDemo03 {
    public static void main(String[] args) {
       // 将数字转换成字符
        String str = new String().valueOf(1);
        System.out.println(str);
        // 或者通过增加空字符串转换
        String str2 = 1+"";
        // 通过包装类将字符转换成数字 。
        Integer i = new Integer(2);
        System.out.println(   i.toString());
        int i2=Integer.parseInt("32324");
    }
}
