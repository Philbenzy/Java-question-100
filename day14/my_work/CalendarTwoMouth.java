package my_work;


import java.util.Calendar;
import java.util.Scanner;

public class CalendarTwoMouth {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        System.out.println("请输入年份：");
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        cal.set(year,2,1);// 设置年月日
        cal.add(Calendar.DATE,-1);// Calendar.Date表示：返回某个月中的一天  // 偏移设置好的内容
        System.out.println(cal.get(Calendar.DATE));// 得到这一天
    }
}
