package my_work.TreeMapTest;


import java.util.Set;
import java.util.TreeMap;

public class TreeMapStringWithString {
    public static void main(String[] args) {
        TreeMap<String,String> tm = new TreeMap<>();

        tm.put("hello", "你好");
        tm.put("world", "世界");
        tm.put("java", "爪哇");
        tm.put("world", "世界2");
        tm.put("javaee", "爪哇EE");

        Set<String> keySet = tm.keySet();
        for (String key : keySet){
            String value = tm.get(key);
            System.out.println(key+"- - -"+value);
        }
    }
}
