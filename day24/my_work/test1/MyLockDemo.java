package my_work.test1;

public class MyLockDemo {
    public static void main(String[] args) {
        MyDieLock dl1 = new MyDieLock(true);
        MyDieLock dl2 = new MyDieLock(false);

        dl1.start();
        dl2.start();
    }
}
