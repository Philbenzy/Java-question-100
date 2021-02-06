package my_work.HashMapTest;

import my_work.MyStudent;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapStringWithObject {
    public static void main(String[] args) {
        Map<String, MyStudent> map = new HashMap<>();

        MyStudent s1 = new MyStudent("wzy", 18);
        MyStudent s2 = new MyStudent("xxx", 27);
        MyStudent s3 = new MyStudent("qqq", 22);

        map.put("001", s1);
        map.put("002", s2);
        map.put("003", s3);

        Set<String> keySet = map.keySet();
        for (String key : keySet){
            MyStudent s = map.get(key);
            System.out.println(key+"- - - "+s.getName()+"- - - "+s.getAge());
        }
    }
}
