package my_work;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class HowOldAreYou {
    public static void main(String[] args) throws Exception {
        System.out.println("请输入你的出生日期:");
        Scanner sc = new Scanner(System.in);
        String youDay = sc.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // 把字符串依据格式解析为一个日期
        Date yourMillions = sdf.parse(youDay);

        long getMillions = yourMillions.getTime(); //得到生日毫秒值

        long getNow = System.currentTimeMillis();// 得到现在的毫秒值

        long day = (getNow - getMillions) / 1000 / 60 / 60 / 24;
        System.out.println("你来到地球上：" + day);


    }
}
