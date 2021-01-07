public class InterFaceDemo2 {
    public static void main(String[] args) {
        Son s = new Son();
        System.out.println(s.age);
        System.out.println(s.age2);

        s.show();
        s.show2();
    }
}

interface Mother{
    public static final int age = 49;

    public abstract void show();
}

interface Father{
    public static final int age2 = 51;

    public abstract void show2();
}

class Son implements Mother,Father{
    public void show(){
        System.out.println("��дmother��show");
    }

    public void show2(){
        System.out.println("��дfather��show2");
    }
}