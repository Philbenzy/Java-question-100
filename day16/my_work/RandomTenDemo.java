package my_work;

import my_work.genericWithInter.Inter;

import java.util.ArrayList;
import java.util.Random;

// ����10�����������Χ��1-20֮�䣬����һ�����ϵ��У������ɱ���
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

        // ��ǿFor����ѭ��
        for (Integer num : arrIntList){
            System.out.println(num);
        }

    }
}
