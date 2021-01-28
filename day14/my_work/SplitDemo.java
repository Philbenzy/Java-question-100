package my_work;

import java.util.Scanner;

/**
 * 说明：
 * (1)给出一个正则匹配字段，使用split()方法分割对象
 * (2)键盘录入一个数字，通过判断得到是否在指定区间内
 */
public class SplitDemo {
    public static void main(String[] args) {
        String regex = "18-24";
        System.out.println("请输入年龄：");
        Scanner sc = new Scanner(System.in);
        int age = sc.nextInt();

        String[] strArray = regex.split("-");

        // 将String 转化为 int 类型
        int startAge = Integer.parseInt(strArray[0]);
        int endAge = Integer.parseInt(strArray[1]);
        if ((startAge <= age) && (age<=endAge)){
            System.out.println("你就是我想找的！");
        }else {
            System.out.println("不符合要求！");
        }
    }
}
