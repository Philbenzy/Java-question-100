/*
案例：猫狗跳高

分析：1.基础的猫狗具有
    （1）成员变量
        姓名、年龄
    （2）成员方法
        吃饭（抽象）、睡觉，设置年龄、设置名称
    （3）构造方法
        无参构造、带参构造

     定义为animal类

    2.实例猫狗中
        吃的方法不同，猫吃鱼，狗吃骨头

    3.定义跳高接口，让实例猫狗具备调高属性
 */

public class InterFaceDemo {
    public static void main(String[] args) {
        JumpDog jd = new JumpDog();
        jd.setAge(3);
        jd.setName("旺财");
        System.out.println(jd.getAge()+"- - -"+jd.getName());
        jd.eat();
        jd.sleep();
        jd.jump();
        System.out.println("- - - - - - ");
        JumpCat jc = new JumpCat(4,"Tom");
        jc.eat();
        jc.sleep();
        jc.jump();
    }
}

interface Jumpping{
    public abstract void jump();
}


abstract class Animal2{
    private int age;
    private String name;

    public Animal2(){}

    public Animal2(int age,String name){
        this.age = age;
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public int getAge(){
        return age;
    }

    public abstract void eat();

    public void sleep(){
        System.out.println("睡觉。。。");
    }
}

class Cat2 extends Animal2{
    public Cat2(){};

    public Cat2(int age,String name){
        super(age,name);
    }
    public void eat(){
        System.out.println("猫吃鱼儿");
    }
}

class Dog2 extends Animal2{
    public Dog2(){}

    public Dog2(int age,String name){
        super(age,name);
    }

    public void eat(){
        System.out.println("狗吃骨头");
    }
}

class JumpCat extends Cat2 implements Jumpping{
    public JumpCat(){}

    public JumpCat(int age,String name){
        super(age, name);
    }

    public void jump(){
        System.out.println("猫跳高。。。");
    }
}

class JumpDog extends Dog2 implements Jumpping{
    public JumpDog(){}

    public JumpDog(int age,String name){
        super(age, name);
    }

    public void jump(){
        System.out.println("狗跳高...");
    }
}