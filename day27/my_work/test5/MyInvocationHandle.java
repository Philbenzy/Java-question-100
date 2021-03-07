package test5;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Date;

public class MyInvocationHandle implements InvocationHandler {
    private Object obj;

    public MyInvocationHandle(Object obj){
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(new Date());
        System.out.println("Ȩ����֤�����Ժ� ^ V ^");
        Object result = method.invoke(obj); // ������еĲ���
        System.out.println("�����Ѽ�¼��886��");
        System.out.println(new Date());
        return result;
    }
}
