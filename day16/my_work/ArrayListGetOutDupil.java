package my_work;

import java.util.ArrayList;
import java.util.Iterator;

// ����һ��װ���ַ����ļ��ϣ��ڼ�����ȥ���ظ�Ԫ�أ�����ӡ��
public class ArrayListGetOutDupil {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("hello");
        list.add("world");
        list.add("java");
        list.add("home");
        list.add("person");
        list.add("world");
        list.add("java");
        list.add("home");
        list.add("person");
        list.add("123");
        list.add("123");

        Iterator<String> it = list.iterator();

        ArrayList<String> newArray = new ArrayList<>();

        // ע�⣬�����whileѭ���ڲ����ܳ�������it.next();
        while (it.hasNext()){
            String s = it.next();
            if (!newArray.contains(s)){
                newArray.add(s);
            }
        }

        // ��ǿfor��ӡԪ��
        for (String str: newArray){
            System.out.println(str);
        }

    }
}
