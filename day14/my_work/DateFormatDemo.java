package my_work;
/**
 * ʹ��SimpleDateFormat��ת���ַ��ĸ�ʽ��
 * Date To String��ʹ��formatת��
 * String To Date��ʹ��Parseת��
 * */

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatDemo {
    public static void main(String[] args) {
        Date d = new Date();
        SimpleDateFormat sdf  = new SimpleDateFormat("yyyy��MM��dd�� HH:mm:mm");
        String strDate = sdf.format(d);
        System.out.println(d);
        System.out.println(strDate);
    }
}
