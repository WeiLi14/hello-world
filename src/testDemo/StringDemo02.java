package testDemo;

/**
 * @ProjectName: JDBCTest
 * @Package: testDemo
 * @ClassName: StringDemo02
 * @Author: HAND_WEILI
 * @Description: ${description}
 * @Date: 2020/6/6 11:14
 * @Version: 1.0
 */
// 该类用于测试字符反转
public class StringDemo02 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("123456");
        //进行反转
        sb.reverse();
        sb.toString();
        System.out.println(sb);
    }
}
