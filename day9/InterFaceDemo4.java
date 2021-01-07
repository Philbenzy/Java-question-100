/*/
要求：定义；老师与学生类，两类都有基本的吃饭和睡觉方法
            同时，学生和老师人群当中，都有一部分呢学坏了，学会抽烟了，来实现一下

            抽象类：人（吃饭、睡觉）
            接口：抽烟
            具体类：老师、学生、抽烟的老师、抽烟的学生

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
        System.out.println("老师吃馒头");
    }

    public void sleep(){
        System.out.println("老师改作业，晚点睡12点");
    }
}
class Student extends Person{
    public void eat(){
        System.out.println("吃红烧肉");
    }

    public void sleep(){
        System.out.println("学生早点睡，明天上课");
    }
}

class SmokingStudent extends Student implements Smoking{
    public void smoke(){
        System.out.println("下课了，得来一根华子吧！");
    }
}

class SmokingTeacher extends Teacher implements Smoking{
    public void smoke(){
        System.out.println("回家了，老师在家来一根");
    }
}