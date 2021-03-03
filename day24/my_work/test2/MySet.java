package my_work.test2;

// 生产者
public class MySet implements Runnable {
    private MyStudent ms;
    int x = 0;

    MySet(MyStudent ms) {
        this.ms = ms;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (ms) {
                if (ms.flag) {
                    try {
                        ms.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    if ((x % 2) == 0) {
                        ms.name = "王紫玉";
                        ms.age = 24;
                    } else {
                        ms.name = "王所银";
                        ms.age = 14;
                    }
                    x++;
                    ms.flag = true;
                    ms.notify();
                }
            }
        }
    }
}
