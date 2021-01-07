public class InterFaceDemo3 {
    public static void main(String[] args) {
        BasketballPlayer bp = new BasketballPlayer();
        bp.eat();
        bp.englishTrain();
        bp.sleep();
        System.out.println("- - - ");

        PingPangPlayer ppp = new PingPangPlayer();
        ppp.eat();
        ppp.sleep();
        ppp.englishTrain();
        System.out.println("- - - ");

        TeacherBasketball tb = new TeacherBasketball();
        tb.eat();
        tb.sleep();
        System.out.println("- - - ");

        TeacherPingPanger tpp = new TeacherPingPanger();
        tpp.eat();
        tpp.sleep();
        tpp.englishTrain();
        System.out.println("- - - ");


    }
}

abstract class Person {

    public abstract void eat();

    public void sleep(){
        System.out.println("˯��");
    };

}

interface EnglishTrain {

    public abstract void englishTrain();
}

class TeacherPingPanger extends Person implements EnglishTrain{
    public void eat(){
        System.out.println("�����Է������������ȿ���");
    }
    public void englishTrain(){
        System.out.println("����������ѧϰӢ��...");
    }
}

class TeacherBasketball extends Person{
    public void eat(){
        System.out.println("�����Է�������ĩ����");
    }
}

class PingPangPlayer extends Person implements EnglishTrain{
    public void eat(){
        System.out.println("ƹ������꣬��������");
    }

    public void englishTrain(){
        System.out.println("����������ѧϰӢ����...");
    }
}
class BasketballPlayer extends Person implements EnglishTrain{
    public void eat(){
        System.out.println("������꣬������");
    }

    public void englishTrain(){
        System.out.println("����������ѧϰӢ���С�����");
    }
}