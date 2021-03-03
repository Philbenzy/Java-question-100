package my_work.HungryAndLazy;

public class LazyDemo {
    public static void main(String[] args) {

        Lazy l1 = Lazy.getLazy();
        Lazy l2 = Lazy.getLazy();
        System.out.println(l1 == l2);
    }
}
