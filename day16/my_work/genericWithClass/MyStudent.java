package my_work.genericWithClass;

/*
 * 在类上定义的同时，也需要在方法上进行定义*/
public class MyStudent<T> {
    private T obj;

    public void setObj(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }
}
