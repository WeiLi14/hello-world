package testDemo;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import javafx.scene.input.DataFormat;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @ProjectName: JDBCTest
 * @Package: testDemo
 * @ClassName: TimeDemo02
 * @Author: HAND_WEILI
 * @Description: ${description}
 * @Date: 2020/6/6 10:23
 * @Version: 1.0
 */
// 该练习用来判断如何获取年月日，小时分钟秒
public class TimeDemo02 {
    public static void main(String[] args) {
        // 需要通过日历类来获取年
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONTH));
        System.out.println(calendar.get(Calendar.DATE));
        // 获取当前毫秒数两种方案
        System.out.println(calendar.getTimeInMillis());
        System.out.println(System.currentTimeMillis());
        // 日期格式的转换
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
        try {
            //将字符转换成一个日期
            Date date = simpleDateFormat.parse("2019-11-12");
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
