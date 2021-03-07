package test5;

import java.lang.reflect.Proxy;

public class ProxyDemo {
    public static void main(String[] args) {
        StudentDao sd = new StudentDaoImpl();

        // （1）创建代理执行内容
        MyInvocationHandle handle = new MyInvocationHandle(sd);

        // （2）创建代理对象
        StudentDao proxy =  (StudentDao) Proxy.newProxyInstance(sd.getClass().getClassLoader(),sd.getClass().getInterfaces(),handle);

        // （3）执行方法
        proxy.login();
        System.out.println("- - -");
        proxy.register();
        System.out.println("- - -");

        // hero类的演示

        HeroDao dh = new HeroDaoImpl();

        MyInvocationHandle handle1 = new MyInvocationHandle(dh);
        HeroDao proxy2 = (HeroDao) Proxy.newProxyInstance(dh.getClass().getClassLoader(),dh.getClass().getInterfaces(),handle1);
        proxy2.think();
        proxy2.work();
    }
}
