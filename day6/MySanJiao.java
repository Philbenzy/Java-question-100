import java.util.Scanner;

public class MySanJiao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("��������Ҫ�����������");
        int n = sc.nextInt();
        int[][] arr = new int[n][n];

        for (int i = 0; i < arr.length; i++) {
            // ����һ�б�Ϊȫ1
            arr[i][0] = 1;
            // �����һ��Ԫ�ر�Ϊ1
            arr[i][i] = 1;
        }
        // ʵ�ִӵ����п�ʼ��ǰһ���Ϸ��ĵ�һ����+�ڶ����� = �ڶ����·�������
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
