public class PersonDemo {
    public static void main(String[] args) {
        Person p = new Person();
        p.name = "WZY";
        p.country = "china";
        p.age = 24;

        p.yourSelfSpeak();
        p.eat();
        p.speak();
        p.sleep();
    }
}

class Person{
    String name;
    int age;
    String country;

    public void speak(){
        System.out.println("˵��....");
    }
    public void eat(){
        System.out.println("�Է�...");
    }
    public void sleep(){
        System.out.println("˯��...");
    }
    public void yourSelfSpeak(){
        System.out.println("�ҵ�������"+name+"���ҽ���"+age+"�꣬������"+country);
    }
}
