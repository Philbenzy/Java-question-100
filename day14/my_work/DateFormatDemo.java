package my_work;
/**
 * 使用SimpleDateFormat类转换字符的格式：
 * Date To String：使用format转换
 * String To Date：使用Parse转换
 * */

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatDemo {
    public static void main(String[] args) {
        Date d = new Date();
        SimpleDateFormat sdf  = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:mm");
        String strDate = sdf.format(d);
        System.out.println(d);
        System.out.println(strDate);
    }
}
