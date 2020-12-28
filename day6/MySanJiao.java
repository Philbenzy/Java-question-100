import java.util.Scanner;

public class MySanJiao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入需要大多的杨辉三角");
        int n = sc.nextInt();
        int[][] arr = new int[n][n];

        for (int i = 0; i < arr.length; i++) {
            // 将第一列变为全1
            arr[i][0] = 1;
            // 将最后一个元素变为1
            arr[i][i] = 1;
        }
        // 实现从第三行开始，前一列上方的第一个数+第二个数 = 第二个下方的数。
        for (int i = 2; i < arr.length; i++) {
            for (int j = 1; j < i; j++) {
                arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
            }
        }
        printList(arr);
    }


    public static void printList(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
