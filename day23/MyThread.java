package my_work;

public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("������ʼִ�У�");
        for (int x = 0; x < 10; x++) {
            System.out.println(getName()+" x:" + x);
        }
        System.out.println("����ִ�����");
    }
}
