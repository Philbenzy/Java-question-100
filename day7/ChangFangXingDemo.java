import java.util.Scanner;

public class ChangFangXingDemo {
    public static void main(String[] args) {
        System.out.println("�������һ������");
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        System.out.println("������ڶ�������");
        int width = sc.nextInt();

        CangFangXing cfx = new CangFangXing(length,width);

        System.out.println("�����"+cfx.mianJi());
        System.out.println("�ܳ���"+cfx.zhouChang());
    }
}

class CangFangXing{
    private int length;
    private int width;

    CangFangXing(int length,int width){
        this.length = length;
        this.width = width;
    }

    public void setLength(int length){
        this.length = length;
    }

    public void setWidth(int width){
        this.width = width;
    }

    public int zhouChang(){
        return (length+width)*2;
    }

    public int mianJi(){
        return (length*width);
    }

}
