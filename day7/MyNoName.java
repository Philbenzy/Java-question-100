public class MyNoName {
    public static void main(String[] args) {
        // 具有名称的对象
        MyStudent ms = new MyStudent();
        ms.method1();

        MyStudentDemo md = new MyStudentDemo();
        // （1）引用类型（类）的传递（2）匿名对象的创建
        md.show(new MyStudent());


    }
}

class MyStudent{
    public void method1(){
        System.out.println("。。。好好学。。。");
    }
}

class MyStudentDemo{
    public void show(MyStudent s){
        s.method1();
    }
}