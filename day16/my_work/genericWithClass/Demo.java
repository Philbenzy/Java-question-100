package my_work.genericWithClass;
/*
* ʹ�÷��Ͷ��������ϣ����������������Ψһ�����⣡*/
public class Demo {
    public static void main(String[] args) {
        MyStudent<String> ms = new MyStudent<String>();
        ms.setObj("WZY");
        String s = ms.getObj();
        System.out.println(s);

        //����2���½�ʱ�����Ƿ���,
        MyStudent ms2 = new MyStudent();
        ms2.setObj("WZY2");
        System.out.println(ms2.getObj());

    }


}
