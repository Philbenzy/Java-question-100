package my_work.genericWithClass;

/*
 * �����϶����ͬʱ��Ҳ��Ҫ�ڷ����Ͻ��ж���*/
public class MyStudent<T> {
    private T obj;

    public void setObj(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }
}
