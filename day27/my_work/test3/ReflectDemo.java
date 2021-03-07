package test3;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Properties prop = new Properties();
        FileReader fr = new FileReader("C:\\Users\\Wzy\\My_work\\zy_Javase\\刘意Java\\配套资料\\day27\\my_work\\test3\\util.txt");
        prop.load(fr);

        String ClassName = prop.getProperty("ClassName");
        String MethodName = prop.getProperty("Method");

        // （1）找到指定类文件
        Class c = Class.forName(ClassName);

        // （2）找到指定构造方法
        Constructor con = c.getConstructor();
        // (3)构造对象
        Object obj = con.newInstance();

        // (3) 得到方法
        //  c.getDeclaredField()得到的为自身方法
        Method m = c.getMethod(MethodName);// 得到父类与自己的方法

        //(4)
        m.invoke(obj);



    }
}
