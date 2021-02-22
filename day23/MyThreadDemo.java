package my_work;

public class MyThreadDemo {
    public static void main(String[] args) {
        MyThread mt1 = new MyThread();
        MyThread mt2 = new MyThread();

        mt1.setPriority(10);

        mt1.start();
        mt2.start();
    }
}
