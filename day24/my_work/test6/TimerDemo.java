package my_work.test6;

import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo {
    public static void main(String[] args) {
        Timer t = new Timer();
        t.schedule(new MyTask(), 3000, 2000);

    }


}

class MyTask extends TimerTask {
    @Override
    public void run() {
        System.out.println("±¬Õ¨£¡");
    }
}
