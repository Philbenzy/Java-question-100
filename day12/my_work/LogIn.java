package my_work;

import java.util.Scanner;

public class LogIn {
    public static void main(String[] args) {
        String name = "admin";
        String pwd = "admin";

        for (int count = 0; count < 3; count++) {
            Scanner sc = new Scanner(System.in);
            System.out.println("����������û���");
            String user_name = sc.nextLine();
            System.out.println("�������������");
            String user_pwd = sc.nextLine();
            if (name.equals(user_name) && pwd.equals(user_pwd)) {
                System.out.println("��¼�ɹ���");
                break;
            } else {
                if ((2 - count) == 0){
                    System.out.println("��¼ʧ�ܣ�������ϵͳ��");
                }else {
                    System.out.println("��½ʧ�ܣ��㻹�У���" + (2 - count) + ")�λ���");
                }
            }

        }
    }
}
