package my_work.HashMapTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapStringWithString {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        map.put("001", "С��");
        map.put("002", "����");
        map.put("003", "С��");

        // �õ�������
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            String value = map.get(key);
            System.out.println("���: "+key+" | ������"+value);
        }

    }
}
