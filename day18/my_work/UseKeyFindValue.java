package my_work;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// 使用键对map进行遍历
public class UseKeyFindValue {
    public static void main(String[] args) {
        Map<String, String> hp = new HashMap<>();

        hp.put("邓超", "孙俪");
        hp.put("黄晓明", "杨颖");
        hp.put("周杰伦", "蔡依林");
        hp.put("刘恺威", "杨幂");

        // 使用「键」对集合进行遍历
        Set<String> s = hp.keySet(); // 将键组合成为一个集合
        for (String str : s){
            System.out.println(str+"- - - "+hp.get(str));
        }

    }
}
