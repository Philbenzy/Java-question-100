package my_work;

import java.util.*;

public class StorageUseCollection {
    public static void main(String[] args) {
        // Collection
        Collection<String> s = new ArrayList<>();
        s.add("hello");
        s.add("world");
        s.add("java");

        for (String str : s) {
            System.out.println(str);
        }
        // ArrayList
        System.out.println("- - - ");
        ArrayList<String> s2 = new ArrayList<>();
        s2.add("hello");
        s2.add("world");
        s2.add("java");

        for (String str : s2) {
            System.out.println(str);
        }
        System.out.println("- - - ");
        // List
        List<String> s3 = new ArrayList<>();
        s3.add("hello");
        s3.add("world");
        s3.add("java");
        for (String str : s3) {
            System.out.println(str);
        }

        System.out.println("- - - ");
        // Vector
        Vector<String> s4 = new Vector<>();
        s4.add("hello");
        s4.add("world");
        s4.add("java");

        for (String str : s4) {
            System.out.println(str);
        }
        System.out.println("- - - ");
        // LinkedList È–¥
        LinkedList<String> s5 = new LinkedList<>();
        s5.add("hello");
        s5.add("world");
        s5.add("java");
        for (String str : s5) {
            System.out.println(str);
        }
    }

}
