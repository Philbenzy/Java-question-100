/*
������è������

������1.������è������
    ��1����Ա����
        ����������
    ��2����Ա����
        �Է������󣩡�˯�����������䡢��������
    ��3�����췽��
        �޲ι��졢���ι���

     ����Ϊanimal��

    2.ʵ��è����
        �Եķ�����ͬ��è���㣬���Թ�ͷ

    3.�������߽ӿڣ���ʵ��è���߱���������
 */

public class InterFaceDemo {
    public static void main(String[] args) {
        JumpDog jd = new JumpDog();
        jd.setAge(3);
        jd.setName("����");
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
        System.out.println("˯��������");
    }
}

class Cat2 extends Animal2{
    public Cat2(){};

    public Cat2(int age,String name){
        super(age,name);
    }
    public void eat(){
        System.out.println("è�����");
    }
}

class Dog2 extends Animal2{
    public Dog2(){}

    public Dog2(int age,String name){
        super(age,name);
    }

    public void eat(){
        System.out.println("���Թ�ͷ");
    }
}

class JumpCat extends Cat2 implements Jumpping{
    public JumpCat(){}

    public JumpCat(int age,String name){
        super(age, name);
    }

    public void jump(){
        System.out.println("è���ߡ�����");
    }
}

class JumpDog extends Dog2 implements Jumpping{
    public JumpDog(){}

    public JumpDog(int age,String name){
        super(age, name);
    }

    public void jump(){
        System.out.println("������...");
    }
}