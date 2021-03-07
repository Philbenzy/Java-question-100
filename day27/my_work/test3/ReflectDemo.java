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
        FileReader fr = new FileReader("C:\\Users\\Wzy\\My_work\\zy_Javase\\����Java\\��������\\day27\\my_work\\test3\\util.txt");
        prop.load(fr);

        String ClassName = prop.getProperty("ClassName");
        String MethodName = prop.getProperty("Method");

        // ��1���ҵ�ָ�����ļ�
        Class c = Class.forName(ClassName);

        // ��2���ҵ�ָ�����췽��
        Constructor con = c.getConstructor();
        // (3)�������
        Object obj = con.newInstance();

        // (3) �õ�����
        //  c.getDeclaredField()�õ���Ϊ������
        Method m = c.getMethod(MethodName);// �õ��������Լ��ķ���

        //(4)
        m.invoke(obj);



    }
}
