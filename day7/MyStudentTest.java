public class MyStudentTest {
    public static void main(String[] args) {
        // 使用类中的setXxx方法赋值
        MyStudent1 ms = new MyStudent1();
        ms.setAge(19);
        ms.setCountry("china");
        ms.setName("王大锤");
        ms.show();

        // 使用构造函数初始化

        MyStudent1 ms1 = new MyStudent1(18,"小花","china");
        ms1.show();

    }
}

class MyStudent1{
    private int age;
    private String name;
    private String country;

    public MyStudent1(int age,String name,String country){
        this.age = age;
        this.name = name;
        this.country = country;
    }

    public MyStudent1(){}

    public void setAge(int age){
        this.age = age;
    }

    public int getAge(){
        return age;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setCountry(String country){
        this.country = country;
    }

    public String getCountry(){
        return country;
    }

    public void show(){
        System.out.println("姓名："+name+" 年龄："+age+" 国家："+country);
    }


}