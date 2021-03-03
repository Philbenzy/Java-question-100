package my_work.test3;

public class ThreadDemo2 {
    public static void main(String[] args) {
        MyStudent2 ms2 = new MyStudent2();

        Get get = new Get(ms2);
        Set set = new Set(ms2);

        Thread t1 = new Thread(get);
        Thread t2 = new Thread(set);

        t2.start();
        t1.start();
    }
}
