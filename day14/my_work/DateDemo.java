package my_work;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo {
    public static void main(String[] args) {
        Date d = new Date(); // 构造方法1
        Date d2 = new Date(1000);// 构造方法2

        System.out.println(d);//
        System.out.println(System.currentTimeMillis());// 得到毫秒值

        System.out.println(d.getTime());// Date成员方法1

        d.setTime(1000);// Date成员方法2
        System.out.println(d);
        System.out.println(d2);

    }
}
