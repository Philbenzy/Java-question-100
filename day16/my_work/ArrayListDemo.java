package my_work;
/*
* Java���͵�ʹ�ã��ڴ�������ʱ�붨�������ʱ
* ������ǿ��ת�͵�ʹ��*/
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("Hello");
        list.add("World");
        list.add("Java");

        Iterator<String> it = list.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}
