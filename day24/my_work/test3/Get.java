package my_work.test3;

public class Get implements Runnable{
    private MyStudent2 ms2;

    Get(MyStudent2 ms2){
        this.ms2 = ms2;
    }

    @Override
    public void run() {
        while (true){
            ms2.get();
        }
    }
}
