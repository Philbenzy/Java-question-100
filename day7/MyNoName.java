public class MyNoName {
    public static void main(String[] args) {
        // �������ƵĶ���
        MyStudent ms = new MyStudent();
        ms.method1();

        MyStudentDemo md = new MyStudentDemo();
        // ��1���������ͣ��ࣩ�Ĵ��ݣ�2����������Ĵ���
        md.show(new MyStudent());


    }
}

class MyStudent{
    public void method1(){
        System.out.println("�������ú�ѧ������");
    }
}

class MyStudentDemo{
    public void show(MyStudent s){
        s.method1();
    }
}