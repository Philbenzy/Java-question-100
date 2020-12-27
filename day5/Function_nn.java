import java.util.Scanner;

public class Function_nn {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("«Î ‰»Înµƒ÷µ£∫");
        int n = sc.nextInt();

        printNN(n);
    }

    public static void printNN(int n) {
        for (int x = 1; x <= n; x++){
            for (int y=1;y<=x;y++){
                System.out.print(y+"*"+x+"="+x*y+"\t");
            }
            System.out.println("");
        }
    }
}
