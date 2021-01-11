// 抽象类通过多态实例化

// 形式参数为抽象类的例子

public class abstractDemo {
    public static void main(String[] args) {
        Learning l = new Student2();
        LearnTool lt = new LearnTool();
        lt.method(l);
    }
}

abstract class Learning{
    public abstract void study();
}

class Student2 extends Learning{
    public void study(){
        System.out.println("我还是爱学习Java");
    }
}

class LearnTool{
    public void method(Learning s){
        s.study();
    }
}
