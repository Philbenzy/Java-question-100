package my_work;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class CountKeyBoardTime {
    public static void main(String[] args) {

        // 创建集合对象
        // 为什么用TreeMap? 因为TreeMap可以保证出现的键唯一，正好满足了统计思想
        TreeMap<Character,Integer> map = new TreeMap<>();

        // 键盘录入字符串
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        // 将字符串转为字符数组
        char[] chs = str.toCharArray();

        // 遍历添加
        for (char ch: chs){
           Integer i  = map.get(ch);
           if (i==null){
               map.put(ch,1);
           }else{
               i++;
               map.put(ch,i);
           }
        }

        // 将结果添加到StringBuilder中，为输出做准备
        StringBuilder sb = new StringBuilder();

        Set<Character> keySet = map.keySet();
        for (Character key: keySet){
            Integer value = map.get(key);
            sb.append(key).append("(").append(value).append(")");
        }

        String result = sb.toString();
        System.out.println(result);
    }
}
