package my_work;

public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("方法开始执行！");
        for (int x = 0; x < 10; x++) {
            System.out.println(getName()+" x:" + x);
        }
        System.out.println("方法执行完毕");
    }
}
