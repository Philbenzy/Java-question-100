/*
定义动物，猫，狗，使后两者继承于动物

在猫与狗中使用两种方式完成初始化
（1）构造方法初始化
（2）成员方法初始化

猫有自己独特的方法playGame()
狗也有自己独特的方法lookDoor()


 */

public class ExtendsDemo2 {
    public static void main(String[] args) {
        Dog d = new Dog();
        // 方法1
        d.setAge(5);
        d.setColor("black");
        d.setName("Tom");
        d.show();
        d.lookDoor();

        // 方法2
        Dog d2 = new Dog("tom",5,"black");
        d2.show();
        d2.lookDoor();

        // 方法1
        Cat c = new Cat();
        c.setAge(3);
        c.setName("jerry");
        c.setColor("purple");
        c.show();
        c.playGame();

        // 方法2
        Cat c2 = new Cat("jerry","purple",3);
        c2.show();
        c2.playGame();


    }
}


class Animal{
    private String name;
    private int age;
    private String color;

    //构造方法
    public Animal(){}

    public Animal(String name,int age, String color){
        this.age = age;
        this.name = name;
        this.color = color;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setColor(String color){
        this.color = color;
    }

    public String getColor(){
        return color;
    }

    public void setAge(int age){
        this.age = age;
    }

    public int getAge(){
        return age;
    }

    public void eat(){
        System.out.println("吃东西。。。");
    }

    public void show(){
        System.out.println(this.name+"- - -"+this.age+"- - -"+this.color);
    }
}

// 定义猫
class Cat extends Animal{
    public Cat(){}

    public Cat(String name,String color,int age){
        super(name, age, color);
    }

    public void playGame(){
        System.out.println("玩游戏");
    }
}

// 定义狗
class Dog extends Animal{
    public Dog(){}

    public Dog(String name, int age, String color){
        super(name, age, color);
    }

    public void lookDoor(){
        System.out.println("汪汪叫，看门！");
    }
}