package my_work;

public class MyStopDemo {
    public static void main(String[] args) {
        MyStop ms = new MyStop();
        ms.start();

        try {
            Thread.sleep(1000);
            ms.interrupt();//����ж�״̬����������յ�һ�� InterruptedException
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
