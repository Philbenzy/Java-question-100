package my_work.genericWithMethod;

// 将泛型定义在方法上
public class MyPerson {
    public <T> void show(T t) {
        System.out.println(t);
    }
}
