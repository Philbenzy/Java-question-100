package my_work.test5;

import java.util.concurrent.Callable;

public class MyCallable implements Callable {
    private int number;

    MyCallable(int number) {
        this.number = number;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= number; i++) {
            sum +=i;
        }

        return sum;
    }
}
