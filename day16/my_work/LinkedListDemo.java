package my_work;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<String> ll = new LinkedList<>();
        // ���ǽ�Ԫ����ӵ���ͷ
        ll.addFirst("hello");
        ll.addFirst("world");
        ll.addFirst("java");

        for (String s : ll){
            System.out.println(s);
        }
    }
}
