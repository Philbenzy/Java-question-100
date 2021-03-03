package my_work.test2;

public class MyDemo {
    public static void main(String[] args) {
        MyStudent ms = new MyStudent();

        MySet set = new MySet(ms);
        MyGet get = new MyGet(ms);

        Thread d1 = new Thread(set);
        Thread d2 = new Thread(get);

        d1.start();
        d2.start();
    }
}
