package my_work;

public class SealTicket implements Runnable{
    private int ticket = 100;
    private Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (obj) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ": 正在出售第 " + ticket + " 张票...");
                    ticket--;
                } else {
                    System.out.println("Sale Out");
                    System.exit(0);
                }
            }
        }
    }
}
