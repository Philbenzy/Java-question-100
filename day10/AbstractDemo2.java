//ʹ�÷��ض���ķ���
// ����
public class AbstractDemo2 {
    public static void main(String[] args) {
        MakeStudents ms = new MakeStudents();
//        Person5 s = ms.getPerson5();
//        s.study();
        ms.getPerson5().study();// ��ʽ
    }
}

abstract class Person5{
    public abstract void study();
}

class Student5 extends Person5{
    public void study(){
        System.out.println("ѧϰѧϰ��ѧϰJava");
    }
}

class MakeStudents{
    public Person5 getPerson5(){ // ����������࣬����������Ϊ����
        return new Student5();
    }
}
