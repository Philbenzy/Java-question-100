package my_work;


import java.util.Comparator;
import java.util.TreeSet;

public class PersonWithComparator {
    public static void main(String[] args) {
        TreeSet<Person> ts = new TreeSet<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                int num = o1.getAge() - o2.getAge();
                int num2 = num == 0 ? o1.getName().compareTo(o2.getName()):num;
                return num2;
            }
        });
        Person p1 = new Person("wzy",18);
        Person p2 = new Person("wzy",18);
        Person p3 = new Person("wzy",19);
        Person p4 = new Person("ÎÒµÄÒ¯Ò¯",78);
        Person p5 = new Person("haha",65);
        Person p6 = new Person("wsy",22);

        ts.add(p1);
        ts.add(p2);
        ts.add(p3);
        ts.add(p4);
        ts.add(p5);
        ts.add(p6);


        for (Person p : ts){
            System.out.println(p.getAge()+"- - - "+p.getName());
        }
    }
}
