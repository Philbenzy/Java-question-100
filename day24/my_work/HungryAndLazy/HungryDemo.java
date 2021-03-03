package my_work.HungryAndLazy;

public class HungryDemo {
    public static void main(String[] args) {
        Hungry h1 = Hungry.getHungry();
        Hungry h2 = Hungry.getHungry();

        System.out.println(h1 == h2);
    }
}
