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
        System.out.println("睡觉");
    };

}

interface EnglishTrain {

    public abstract void englishTrain();
}

class TeacherPingPanger extends Person implements EnglishTrain{
    public void eat(){
        System.out.println("教练吃饭，吃西红柿喝可乐");
    }
    public void englishTrain(){
        System.out.println("出国交换，学习英文...");
    }
}

class TeacherBasketball extends Person{
    public void eat(){
        System.out.println("教练吃饭，吃肉末面条");
    }
}

class PingPangPlayer extends Person implements EnglishTrain{
    public void eat(){
        System.out.println("乒乓球打完，吃西红柿");
    }

    public void englishTrain(){
        System.out.println("出国交换，学习英文中...");
    }
}
class BasketballPlayer extends Person implements EnglishTrain{
    public void eat(){
        System.out.println("篮球打完，吃面条");
    }

    public void englishTrain(){
        System.out.println("出国交换，学习英文中。。。");
    }
}