package my_work.HashMapTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapIntegerWithString {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();

        map.put(55, "»Êºó");
        map.put(27, "Kurt Coban");
        map.put(18, "ÕÅ¹úÈÙ");



        Set<Integer> keySet = map.keySet();
        for (Integer key : keySet){
               String value = map.get(key);
            System.out.println(key+"- - - "+value);
        }
    }
}
