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
        System.out.println("权限验证，请稍后！ ^ V ^");
        Object result = method.invoke(obj); // 代理进行的操作
        System.out.println("访问已记录！886！");
        System.out.println(new Date());
        return result;
    }
}
