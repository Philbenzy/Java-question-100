package my_work;

import java.util.Calendar;
import java.util.TimeZone;

public class CalendarDemo {
    public static void main(String[] args) {
        Calendar rightNow = Calendar.getInstance(); // Calendar类是一个抽象类，这里的创建实际上是使用到了多态
        int year = rightNow.get(Calendar.YEAR);
        int mouth = rightNow.get(Calendar.MONTH);
        int hour = rightNow.get(Calendar.DATE);
        int year2 = Calendar.getInstance().get(Calendar.YEAR);
        TimeZone timeZone = rightNow.getTimeZone();
        System.out.println(year2);
        System.out.println(mouth+1);
        System.out.println(hour);
        System.out.println(timeZone);
    }
}
