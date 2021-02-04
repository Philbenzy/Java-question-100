package my_work;
// 使用hashSet存储String类型并且进行遍历

import java.util.HashSet;

public class HashSetStorageString {
    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<>();

        hs.add("Hello");
        hs.add("Java");
        hs.add("java");
        hs.add("World");
        hs.add("Java"); // 重复元素，set中会进行剔除

        for (String s: hs){
            System.out.println(s);
        }

    }
}
