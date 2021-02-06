package my_work.HashMapTest;

import my_work.MyStudent;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapObjectWithString {
    public static void main(String[] args) {
        Map<MyStudent,String> map = new HashMap<>();

        MyStudent s1 = new MyStudent("��������",50);
        MyStudent s2 = new MyStudent("�Ϻ�����",55);
        MyStudent s3 = new MyStudent("��������",25);
        MyStudent s4 = new MyStudent("��������",25); // ��Ҫ��д��������ȥ���ظ�

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
