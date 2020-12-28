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
        System.out.println("说话....");
    }
    public void eat(){
        System.out.println("吃饭...");
    }
    public void sleep(){
        System.out.println("睡觉...");
    }
    public void yourSelfSpeak(){
        System.out.println("我的名字是"+name+"，我今年"+age+"岁，我来自"+country);
    }
}
