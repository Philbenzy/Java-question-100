/*/
Ҫ�󣺶��壻��ʦ��ѧ���࣬���඼�л����ĳԷ���˯������
            ͬʱ��ѧ������ʦ��Ⱥ���У�����һ������ѧ���ˣ�ѧ������ˣ���ʵ��һ��

            �����ࣺ�ˣ��Է���˯����
            �ӿڣ�����
            �����ࣺ��ʦ��ѧ�������̵���ʦ�����̵�ѧ��

 */

public class InterFaceDemo4 {
    public static void main(String[] args) {
        SmokingStudent ss = new SmokingStudent();
        ss.eat();
        ss.sleep();
        ss.smoke();
        System.out.println("- - - ");

        SmokingTeacher st = new SmokingTeacher();
        st.eat();
        st.sleep();
        st.smoke();
    }
}

abstract class Person {
    abstract public void eat();

    abstract public void sleep();
}
interface Smoking{
    public abstract void smoke();
}

class Teacher extends Person{
    public void eat(){
        System.out.println("��ʦ����ͷ");
    }

    public void sleep(){
        System.out.println("��ʦ����ҵ�����˯12��");
    }
}
class Student extends Person{
    public void eat(){
        System.out.println("�Ժ�����");
    }

    public void sleep(){
        System.out.println("ѧ�����˯�������Ͽ�");
    }
}

class SmokingStudent extends Student implements Smoking{
    public void smoke(){
        System.out.println("�¿��ˣ�����һ�����Ӱɣ�");
    }
}

class SmokingTeacher extends Teacher implements Smoking{
    public void smoke(){
        System.out.println("�ؼ��ˣ���ʦ�ڼ���һ��");
    }
}