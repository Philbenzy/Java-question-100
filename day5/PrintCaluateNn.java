import java.util.Scanner;

public class PrintCaluateNn {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个数字，接下来打印乘法表NxN");
        int n = sc.nextInt();
        print_Number(n);
    }
    public static void print_Number(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i+"*"+j+"="+i*j+"\t");
            }
            System.out.println();
        }
    }
}
