package my_work;

import java.util.HashSet;

public class HashSetStorageObject {
    public static void main(String[] args) {
        HashSet<Person> sh = new HashSet<>();

        Person p1 = new Person("wzy", 18);
        Person p2 = new Person("wsy", 18);
        Person p3 = new Person("����֥", 22);
        Person p4 = new Person("��������", 26);
        Person p5 = new Person("wsy", 18);
        Person p6 = new Person("����֥", 23);

        sh.add(p1);
        sh.add(p2);
        sh.add(p3);
        sh.add(p4);
        sh.add(p5);
        sh.add(p6);

        for (Person p : sh) {
            System.out.println("������" + p.getName() + "- - - "+"���䣺"+ p.getAge());
        }


    }
}
