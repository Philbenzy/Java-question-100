package my_work;

public class SynDemo {
    public static void main(String[] args) {
        SealTicket st= new SealTicket();

        Thread t1 = new Thread(st,"window1");
        Thread t2 = new Thread(st,"window2");
        Thread t3 = new Thread(st,"window3");
        Thread t4 = new Thread(st,"window4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
