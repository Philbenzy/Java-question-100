package test1;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Reflect {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {

        Class c = Class.forName("test1.Person");

        Constructor con = c.getConstructor();
        Object obj = con.newInstance();
        System.out.println(obj);

        Field nameField = c.getDeclaredField("name");
        nameField.setAccessible(true);
        nameField.set(obj,"WZY");

        Field ageField = c.getDeclaredField("age");
        ageField.setAccessible(true);
        ageField.set(obj,26);

        Field addressField = c.getField("address");
        addressField.set(obj,"º¼ÖÝ");

        System.out.println(obj);
    }
}
