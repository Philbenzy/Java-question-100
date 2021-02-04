package my_work;

import java.util.TreeSet;

public class StudentWithComparable {
    public static void main(String[] args) {
        TreeSet<Student> ts = new TreeSet<>();

        Student s1 = new Student("wzy", 80, 99, 90);
        Student s2 = new Student("wsy", 100, 100, 100);
        Student s3 = new Student("ly", 59, 59, 59);
        Student s4 = new Student("zhh",35,25,15);
        Student s5 = new Student("zhh",35,15,15);
        Student s6 = new Student("zhh",55,25,15);

        ts.add(s1);
        ts.add(s2);
        ts.add(s3);
        ts.add(s4);
        ts.add(s5);
        ts.add(s6);

        for (Student s: ts){
            System.out.println("|姓名：\t"+s.getName()+"|总分：\t"+s.sum()+"| 语文：\t"+s.getChineseGrand()+"| 数学：\t"+s.getMathGrand()+"| 英语：\t"+s.getEnglishGrand());
        }
    }
}
