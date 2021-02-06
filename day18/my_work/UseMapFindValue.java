package my_work;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UseMapFindValue {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();

        map.put("Ñî¹ı", "Ğ¡ÁúÅ®");
        map.put("¹ù¾¸", "»ÆÈØ");
        map.put("Ñî¿µ", "ÄÂÄî´È");
        map.put("³ÂĞş·ç", "Ã·³¬·ç");

        Set<Map.Entry<String,String>> s = map.entrySet();
        for (Map.Entry<String,String> s2 : s){
            String name = s2.getKey();
            String value = s2.getValue();

            System.out.println("name: "+name+" value: "+value);
        }
    }
}
