//������ʾ��è����̬

//1 è���в�ͬ��˯����Է�����
//2 ����һ������animal��������һ��ĳԷ���˯������
//3 ��дһ�������࣬�������Ե������еķ�����ִ�гԷ���˯��
// �������д�����ֶ�̬˼��

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
        System.out.println("è�Է�");
    }

    public void sleep(){
        System.out.println("è˯��");
    }
}

class Dog extends Animal{
    public void eat(){
        System.out.println("���Է�");
    }

    public void sleep(){
        System.out.println("��˯��");
    }
}

class AnimalTool{
    private AnimalTool(){}

    public static void useAnimal(Animal a){ // ���ֶ�̬
        a.eat();
        a.sleep();
    }
}