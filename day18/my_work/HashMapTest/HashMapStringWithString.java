package my_work.HashMapTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapStringWithString {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        map.put("001", "小明");
        map.put("002", "阿呆");
        map.put("003", "小花");

        // 得到键集合
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            String value = map.get(key);
            System.out.println("编号: "+key+" | 姓名："+value);
        }

    }
}
