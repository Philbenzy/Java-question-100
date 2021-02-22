package my_work;

public class MyStopDemo {
    public static void main(String[] args) {
        MyStop ms = new MyStop();
        ms.start();

        try {
            Thread.sleep(1000);
            ms.interrupt();//清除中断状态清除，它将收到一个 InterruptedException
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
