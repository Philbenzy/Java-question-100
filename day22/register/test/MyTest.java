package register.test;

import register.dao.UserDao;
import register.dao.impl.UserDaoImpl;
import register.pojo.User;

import java.util.Scanner;

/**
 * ����һ�������࣬���ڲ���
 * ��1���û���¼
 * ��2���û�ע��
 * ��3����½�ɹ���ʾ�Ƿ������Ϸ*/
public class MyTest {
    public static void main(String[] args) {
        while(true){
            System.out.println("- - - - �û���¼ҳ�� - - - -");
            System.out.println("- - - - 1���û�ע�� - - - - ");
            System.out.println("- - - - 2���û���¼ - - - - ");
            System.out.println("- - - -   3���˳�  - - - - ");
            System.out.println();
            System.out.println();
            System.out.println("��ѡ���������");

            Scanner sc = new Scanner(System.in);

            UserDao ud = new UserDaoImpl();

            String choice = sc.nextLine();
            switch (choice){
                case "1":
                    System.out.println("- - - - 1���û�ע�� - - - - ");
                    System.out.println("�������û���");
                    String userName = sc.nextLine();
                    System.out.println("�������û�����");
                    String userPassword = sc.nextLine();

                    // ����Ϣ��װΪ����
                    User user = new User();
                    user.setName(userName);
                    user.setPassword(userPassword);
                    ud.register(user);
                    System.out.println("�û�ע����ɣ�");
                    break;

                case"2":
                    System.out.println("�������û�������");
                    String name = sc.nextLine();
                    System.out.println("�������û����룺");
                    String password = sc.nextLine();

                    boolean flag = ud.isLogin(name,password);
                    if (flag){
                        System.out.println("��Ϸ���ڣ���Ҫ����y/n");
                        while (true){
                            String gameChoice = sc.nextLine();
                            if (gameChoice.equalsIgnoreCase("y")){
                                cn.itcast_08.GuessNumber.start();
                                System.out.println("�㻹����y/n");
                            }else {
                                break;
                            }
                        }

                    }else {
                        System.out.println("�û���½ʧ��");
                    }
                case"3":
                    System.out.println("��ӭ�´�������");
                    System.exit(0);
                    break;
            }
        }
    }
}
