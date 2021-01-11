//使用返回对象的方法
// 返回
public class AbstractDemo2 {
    public static void main(String[] args) {
        MakeStudents ms = new MakeStudents();
//        Person5 s = ms.getPerson5();
//        s.study();
        ms.getPerson5().study();// 链式
    }
}

abstract class Person5{
    public abstract void study();
}

class Student5 extends Person5{
    public void study(){
        System.out.println("学习学习爱学习Java");
    }
}

class MakeStudents{
    public Person5 getPerson5(){ // 构造的是子类，但接受类型为父类
        return new Student5();
    }
}
