package my_work;

import java.util.Date;

public class MyStop extends Thread {
    @Override
    public void run() {
        System.out.println("�߳̿�ʼִ�У�");
        try{
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            //e.printStackTrace();
            System.out.println("�̱߳���ֹ");
        }
        System.out.println("����ɩ����ã�����������Ҫ30��");
    }
}
