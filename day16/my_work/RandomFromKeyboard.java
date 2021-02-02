package my_work;

// 从键盘录入数字（整数）以0为结束标志，打印出出最大值，并且打印

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class RandomFromKeyboard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> list = new ArrayList<>();

        while (true){
            System.out.println("请输入数字（整数）");
            int num = sc.nextInt();

            if (num!=0){
                list.add(num);
            }else {
                break;
            }
        }

        // 将ArrayList转换为数组，进而使用数组方法进行排序
        Integer[] i = new Integer[list.size()];

        // toArray() 方法将 Arraylist 对象转换为数组。
        list.toArray(i);

        // 调用Array静态方法进行排序
        Arrays.sort(i);

        // 打印字符串
        System.out.println("数组是："+arrayToString(i)+"同时，该数组中的最大值为："+i[i.length-1]);
    }

    public static String arrayToString(Integer[] i){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int x = 0;x < i.length;x++){
            if (x==i.length-1){
                sb.append(i[x]);
            }else {
                sb.append(i[x]).append(", ");
            }
        }
        sb.append("]");

        return sb.toString();
    }
}
