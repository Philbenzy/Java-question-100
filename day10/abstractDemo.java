// ������ͨ����̬ʵ����

// ��ʽ����Ϊ�����������

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
        System.out.println("�һ��ǰ�ѧϰJava");
    }
}

class LearnTool{
    public void method(Learning s){
        s.study();
    }
}
