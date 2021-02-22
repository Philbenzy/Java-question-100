package my_work;

public class MyThreadJoin {
    public static void main(String[] args) {
        MyThread ms1 = new MyThread();
        MyThread ms2 = new MyThread();

        ms1.setName("Thread-1");
        ms2.setName("Thread-2");
        ms1.start();

        try{
            ms1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ms2.start();
        System.out.println(Thread.currentThread().getName()+"执行完毕，以Thread1优先");
    }
}

