public class AbstractDemo {
    public static void main(String[] args) {
        Car c = new Benz();
        c.oil();
        c.run();
        //c.method();Ѱ�Ҳ���
        System.out.println("- - - ");
        Benz z = (Benz)c;
        ((Benz) c).method();

    }
}


abstract class Car{
    public abstract void oil();

    public abstract void run();

    public Car(){} // ���췽����������û���ã��޷�ʵ����
}

class Benz extends Car{
    public void oil(){
        System.out.println("���ۼ���");
    }

    public void run(){
        System.out.println("������ʻ��");
    }

    public void method(){
        System.out.println("Benz�����з���");
    }
}
