package my_work;

import java.util.Date;

public class MyStop extends Thread {
    @Override
    public void run() {
        System.out.println("线程开始执行！");
        try{
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            //e.printStackTrace();
            System.out.println("线程被终止");
        }
        System.out.println("大哥大嫂过年好！，本来我需要30秒");
    }
}
