package my_work;

import my_work.genericWithInter.Inter;

import java.util.ArrayList;
import java.util.Random;

// 生成10个随机数，范围在1-20之间，放入一个集合当中，最后完成遍历
public class RandomTenDemo {
    public static void main(String[] args) {
        ArrayList<Integer> arrIntList = new ArrayList<>();
        Random r = new Random();

        int count = 0;

        while (count < 10) {
            int number = r.nextInt(20) + 1;
            if (!arrIntList.contains(number))
                arrIntList.add(number);
                count++;
        }

        // 增强For遍历循环
        for (Integer num : arrIntList){
            System.out.println(num);
        }

    }
}
