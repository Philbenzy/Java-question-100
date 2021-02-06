package my_work.HashMapTest;

import my_work.MyStudent;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapObjectWithString {
    public static void main(String[] args) {
        Map<MyStudent,String> map = new HashMap<>();

        MyStudent s1 = new MyStudent("北海舰队",50);
        MyStudent s2 = new MyStudent("南海舰队",55);
        MyStudent s3 = new MyStudent("东海舰队",25);
        MyStudent s4 = new MyStudent("东海舰队",25); // 需要重写方法才能去除重复

        map.put(s1,"001");
        map.put(s2,"002");
        map.put(s3,"003");
        map.put(s4,"004");

        Set<MyStudent> keySet = map.keySet();
        for (MyStudent s: keySet){
            String value = map.get(s);
            System.out.println(s.getName()+"- - - "+s.getAge()+"- - - "+value);
        }
    }
}
