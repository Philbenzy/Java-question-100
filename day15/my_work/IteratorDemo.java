package my_work;
/**
 * 使用集合特有的迭代器进行集合的遍历*/
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

            String s = (String)it.next();  // String s = (String)it.next; 集合中存储的元素为Object类型的元素，需要向下转型才可以进行使用
            System.out.println(s);

        }
        // 学生类
        Collection c2 = new ArrayList();
        Student s1 = new Student(18,"wzy");
        Student s2 = new Student(20,"wsy");

        c2.add(s1);
        c2.add(s2);
        Iterator it2 = c2.iterator();
        while (it2.hasNext()){
            Student stu = (Student)it2.next();// 将Object类型向下转型为了Student类，next方法返回的是一个Object类型
            System.out.println(stu.getAge()+"---"+stu.getName());
        }


    }
}
