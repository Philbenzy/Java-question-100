/*
* 程序构造了person teacher student类，后两个继承于person
* 使用两种不同的方法进行初始化新变量
* 使用super关键字调用父类构造方法
*
*/

public class ExtendsDemo {
    public static void main(String[] args) {
        // 方法1，使用成员方法初始化
        Teacher t = new Teacher();
        t.setAge(24);
        t.setName("wzy");
        System.out.println(t.getAge()+" - -teacher- - "+t.getName());
        // 方法2，使用构造方法
        Student s = new Student("wzy",25);
        System.out.println(s.getAge()+" - -student- - "+s.getName());

    }
}


class Person {
    private String name;
    private int age;

    public  Person(){}

    public  Person(String name, int age){
        this.age = age;
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public int getAge(){
        return age;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}


class Teacher extends Person{
    public Teacher(){}

    public Teacher(String name,int age){
        super(name,age);
    }
}

class Student extends Person{
    public Student(){}

    public Student(String name,int age){
        super(name, age); // 访问父类构造方法
        System.out.println("这条语句来自学生类内部的构造方法");
    }
}