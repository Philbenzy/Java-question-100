package my_work;

import java.util.ArrayList;
import java.util.Iterator;

// 生成一个装有字符串的集合，在集合中去除重复元素，最后打印它
public class ArrayListGetOutDupil {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("hello");
        list.add("world");
        list.add("java");
        list.add("home");
        list.add("person");
        list.add("world");
        list.add("java");
        list.add("home");
        list.add("person");
        list.add("123");
        list.add("123");

        Iterator<String> it = list.iterator();

        ArrayList<String> newArray = new ArrayList<>();

        // 注意，这里的while循环内不可能出现两次it.next();
        while (it.hasNext()){
            String s = it.next();
            if (!newArray.contains(s)){
                newArray.add(s);
            }
        }

        // 增强for打印元素
        for (String str: newArray){
            System.out.println(str);
        }

    }
}
