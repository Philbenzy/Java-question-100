package my_work;
// ʹ��hashSet�洢String���Ͳ��ҽ��б���

import java.util.HashSet;

public class HashSetStorageString {
    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<>();

        hs.add("Hello");
        hs.add("Java");
        hs.add("java");
        hs.add("World");
        hs.add("Java"); // �ظ�Ԫ�أ�set�л�����޳�

        for (String s: hs){
            System.out.println(s);
        }

    }
}
