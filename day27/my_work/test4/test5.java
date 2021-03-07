package test4;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

// 在指定泛型的ArrayList中，放入不同类型元素（这样可以的原因是因为泛型起的作用只是在编译阶段，）
public class test5 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ArrayList<Integer> array = new ArrayList<>(); // 两个方法，得到的

        // Class c = Class.getName("");
        Class c = array.getClass();

        Method m = c.getMethod("add", Object.class);

        // 反射
        m.invoke(array,10);
        m.invoke(array,"hello");
        System.out.println(array);
    }
}
