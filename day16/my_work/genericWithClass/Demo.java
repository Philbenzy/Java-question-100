package my_work.genericWithClass;
/*
* 使用泛型定义在类上，解决传入数据类型唯一的问题！*/
public class Demo {
    public static void main(String[] args) {
        MyStudent<String> ms = new MyStudent<String>();
        ms.setObj("WZY");
        String s = ms.getObj();
        System.out.println(s);

        //方法2，新建时不考虑泛型,
        MyStudent ms2 = new MyStudent();
        ms2.setObj("WZY2");
        System.out.println(ms2.getObj());

    }


}
