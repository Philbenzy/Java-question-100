package my_work;

import java.util.ArrayList;
import java.util.Iterator;
/**
 * Ҫ�󣺲��ܴ����µļ���
 * ʹ��forѭ�����ڲ��Ƚ�Ԫ�أ�����ظ������޳�*/
public class ArrayListWithNoNew {
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

        for (int x = 0; x<list.size()-1;x++){
            for (int y =x+1; y< list.size();y++){
                if (list.get(x).equals(list.get(y))){
                    list.remove(x);
                    y--; // ������Ҫע�����ArrayList��ɾ��Ԫ�غ󣬺�ߵ�Ԫ�ػ���ǰ��λ
                }
            }
        }
        System.out.println(list);
        for (String s: list){
            System.out.println(s);
        }
    }
}
