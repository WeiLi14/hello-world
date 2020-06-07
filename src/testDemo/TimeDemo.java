package testDemo;

import java.util.Calendar;

/**
 * @ProjectName: JDBCTest
 * @Package: testDemo
 * @ClassName: TimeDemo
 * @Author: HAND_WEILI
 * @Description: ${description}
 * @Date: 2020/6/6 10:13
 * @Version: 1.0
 */
// 该类用于测试日和打印昨天当前时刻。
public class TimeDemo {
    public static void main(String[] args) {
        // 获取日历类的实例
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE,-1);
        System.out.println(Calendar.YEAR+""+ Calendar.MONTH+""+  Calendar.DATE);
        System.out.println(calendar.getTime());
    }
}
