package my_work;

import java.util.ArrayList;
import java.util.Iterator;
/**
 * 要求：不能创建新的集合
 * 使用for循环在内部比较元素，如果重复，则剔除*/
public class ArrayListWithNoNew {
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

        for (int x = 0; x<list.size()-1;x++){
            for (int y =x+1; y< list.size();y++){
                if (list.get(x).equals(list.get(y))){
                    list.remove(x);
                    y--; // 这里需要注意的是ArrayList在删除元素后，后边的元素会向前补位
                }
            }
        }
        System.out.println(list);
        for (String s: list){
            System.out.println(s);
        }
    }
}
