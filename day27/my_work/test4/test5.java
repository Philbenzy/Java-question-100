package test4;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

// ��ָ�����͵�ArrayList�У����벻ͬ����Ԫ�أ��������Ե�ԭ������Ϊ�����������ֻ���ڱ���׶Σ���
public class test5 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ArrayList<Integer> array = new ArrayList<>(); // �����������õ���

        // Class c = Class.getName("");
        Class c = array.getClass();

        Method m = c.getMethod("add", Object.class);

        // ����
        m.invoke(array,10);
        m.invoke(array,"hello");
        System.out.println(array);
    }
}
