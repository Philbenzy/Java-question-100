package my_work.TreeMapTest;

import my_work.MyStudent;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapStudentWithString {
    public static void main(String[] args) {
        TreeMap<MyStudent,String> tm = new TreeMap<>(new Comparator<MyStudent>() {
            @Override
            public int compare(MyStudent s1, MyStudent s2) {
                int num = s1.getAge()-s2.getAge();
                int num2 = num ==0? s1.getName().compareTo(s2.getName()):num;
                return num2;
            }
        });

        MyStudent s1 = new MyStudent("ÅË°²", 30);
        MyStudent s2 = new MyStudent("ÁøÏÂ»İ", 35);
        MyStudent s3 = new MyStudent("ÌÆ²®»¢", 33);
        MyStudent s4 = new MyStudent("ÑàÇà", 32);
        MyStudent s5 = new MyStudent("ÌÆ²®»¢", 33);

        tm.put(s1,"001");
        tm.put(s2,"002");
        tm.put(s3,"003");
        tm.put(s4,"004");
        tm.put(s5,"005");

        Set<MyStudent> keySet = tm.keySet();
        for (MyStudent key: keySet){
            String value = tm.get(key);
            System.out.println(key.getName()+"---"+key.getAge()+"---"+value);
        }
    }
}
