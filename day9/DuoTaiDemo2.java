//案例演示：猫狗多态

//1 猫狗有不同的睡觉与吃饭方法
//2 定义一个父类animal，里面有一般的吃饭与睡觉方法
//3 编写一个工具类，让它可以调用类中的方法，执行吃饭、睡觉
// 工具类编写体体现多态思想

public class DuoTaiDemo2 {
    public static void main(String[] args) {
        Cat c = new Cat();
        AnimalTool.useAnimal(c);

        Dog d = new Dog();
        AnimalTool.useAnimal(d);
    }
}


class Animal{
    public void eat(){
        System.out.println("eat");
    }

    public void sleep(){
        System.out.println("sleep");
    }
}

class Cat extends Animal{
    public void eat(){
        System.out.println("猫吃饭");
    }

    public void sleep(){
        System.out.println("猫睡觉");
    }
}

class Dog extends Animal{
    public void eat(){
        System.out.println("狗吃饭");
    }

    public void sleep(){
        System.out.println("狗睡觉");
    }
}

class AnimalTool{
    private AnimalTool(){}

    public static void useAnimal(Animal a){ // 体现多态
        a.eat();
        a.sleep();
    }
}