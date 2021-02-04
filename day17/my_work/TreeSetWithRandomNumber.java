package my_work;

import java.util.Random;
import java.util.TreeSet;

public class TreeSetWithRandomNumber {
    public static void main(String[] args) {
        TreeSet<Integer> ts = new TreeSet<>();

        Random r = new Random();
        // Integer类中实现了comparable接口所以为了方便就使用Integer

        while (ts.size() < 10) {
            Integer i = r.nextInt(20) + 1;
            ts.add(i);
        }

        for (Integer num : ts) {
            System.out.println(num);
        }

    }
}
