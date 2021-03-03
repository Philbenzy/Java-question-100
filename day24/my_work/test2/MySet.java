package my_work.test2;

// ������
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
                        ms.name = "������";
                        ms.age = 24;
                    } else {
                        ms.name = "������";
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
