package test2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectDemo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class c = Class.forName("test1.Person");

        Constructor con = c.getDeclaredConstructor();

        Object obj = con.newInstance();

        Method m = c.getDeclaredMethod("show");

        m.invoke(obj);

        System.out.println("- - ");

        Method m2 = c.getMethod("method", String.class);
        m2.invoke(obj,"nihao");

        System.out.println("- - ");
        Method m3 = c.getMethod("getString", String.class, int.class);
        Object o = m3.invoke(obj,"ÄãºÃ",003);
        System.out.println(o);

    }
}
