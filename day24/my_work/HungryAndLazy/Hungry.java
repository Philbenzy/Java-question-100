package my_work.HungryAndLazy;

// 饿汉式
public class Hungry {
    // 1私有构造
    private Hungry(){};
    // 2创建对象
    private static Hungry h = new Hungry();

    // 3提供访问方法
    public static Hungry getHungry(){
        return h;
    }

}
