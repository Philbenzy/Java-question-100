public class AbstractDemo {
    public static void main(String[] args) {
        Car c = new Benz();
        c.oil();
        c.run();
        //c.method();寻找不到
        System.out.println("- - - ");
        Benz z = (Benz)c;
        ((Benz) c).method();

    }
}


abstract class Car{
    public abstract void oil();

    public abstract void run();

    public Car(){} // 构造方法不报错，但没有用，无法实例化
}

class Benz extends Car{
    public void oil(){
        System.out.println("奔驰加油");
    }

    public void run(){
        System.out.println("奔驰行驶！");
    }

    public void method(){
        System.out.println("Benz的特有方法");
    }
}
