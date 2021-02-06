package my_work.TreeMapTest;


import java.util.Set;
import java.util.TreeMap;

public class TreeMapStringWithString {
    public static void main(String[] args) {
        TreeMap<String,String> tm = new TreeMap<>();

        tm.put("hello", "���");
        tm.put("world", "����");
        tm.put("java", "צ��");
        tm.put("world", "����2");
        tm.put("javaee", "צ��EE");

        Set<String> keySet = tm.keySet();
        for (String key : keySet){
            String value = tm.get(key);
            System.out.println(key+"- - -"+value);
        }
    }
}
