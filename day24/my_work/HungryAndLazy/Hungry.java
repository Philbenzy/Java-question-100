package my_work.HungryAndLazy;

// ����ʽ
public class Hungry {
    // 1˽�й���
    private Hungry(){};
    // 2��������
    private static Hungry h = new Hungry();

    // 3�ṩ���ʷ���
    public static Hungry getHungry(){
        return h;
    }

}
