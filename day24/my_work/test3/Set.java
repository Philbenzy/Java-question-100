package my_work.test3;

public class Set implements Runnable {
    private MyStudent2 ms2;
    private int x = 0;

    public Set(MyStudent2 ms2) {
        this.ms2 = ms2;
    }

    @Override
    public void run() {
        while (true) {
            if (x % 2 == 0) {
                ms2.set("WZY", 24);
            } else {
                ms2.set("WSY", 22);
            }
            x++;
        }
    }
}
