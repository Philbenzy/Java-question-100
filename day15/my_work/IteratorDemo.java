package my_work;
/**
 * ʹ�ü������еĵ��������м��ϵı���*/
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IteratorDemo {
    public static void main(String[] args) {
        Collection c = new ArrayList();
        c.add("hello");
        c.add("world");
        c.add("java");

        Iterator it = c.iterator();
//        System.out.println(it.next());
//        System.out.println(it.next());
//        System.out.println(it.next());

        while (it.hasNext()){
            //System.out.println(it.next());

            String s = (String)it.next();  // String s = (String)it.next; �����д洢��Ԫ��ΪObject���͵�Ԫ�أ���Ҫ����ת�Ͳſ��Խ���ʹ��
            System.out.println(s);

        }
        // ѧ����
        Collection c2 = new ArrayList();
        Student s1 = new Student(18,"wzy");
        Student s2 = new Student(20,"wsy");

        c2.add(s1);
        c2.add(s2);
        Iterator it2 = c2.iterator();
        while (it2.hasNext()){
            Student stu = (Student)it2.next();// ��Object��������ת��Ϊ��Student�࣬next�������ص���һ��Object����
            System.out.println(stu.getAge()+"---"+stu.getName());
        }


    }
}
