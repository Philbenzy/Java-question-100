package my_work;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo {
    public static void main(String[] args) {
        Date d = new Date(); // ���췽��1
        Date d2 = new Date(1000);// ���췽��2

        System.out.println(d);//
        System.out.println(System.currentTimeMillis());// �õ�����ֵ

        System.out.println(d.getTime());// Date��Ա����1

        d.setTime(1000);// Date��Ա����2
        System.out.println(d);
        System.out.println(d2);

    }
}
