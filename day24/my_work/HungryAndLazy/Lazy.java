package my_work.HungryAndLazy;

public class Lazy {
    private Lazy(){};

    private static Lazy l = null;

    public static Lazy getLazy(){
        if (l == null){
            l =  new Lazy();
        }
        return l;
    }
}
