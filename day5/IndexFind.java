//������(���ݼ���¼������,���Ҷ�Ӧ����)

import java.util.Scanner;
public class IndexFind {
    public static void main(String[] args) {
        String[] arr = {"����һ","���ڶ�","������","������","������","������","������",};
        System.out.print("�������������(0-6)��");
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        System.out.println("�����Ĳ��ҽ��Ϊ��"+arr[a]);
    }
}
