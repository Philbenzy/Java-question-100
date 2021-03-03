package my_work.test5;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MyExecutorsDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(2);

        Future<Integer> sum1 = pool.submit(new MyCallable(100));
        Future<Integer> sum2 = pool.submit(new MyCallable(200));

        Integer i1 = sum1.get();
        Integer i2 = sum2.get();
        System.out.println("sum1:"+i1);
        System.out.println("sum2:"+i2);

        pool.shutdown();
    }


}