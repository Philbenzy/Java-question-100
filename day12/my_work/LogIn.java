package my_work;

import java.util.Scanner;

public class LogIn {
    public static void main(String[] args) {
        String name = "admin";
        String pwd = "admin";

        for (int count = 0; count < 3; count++) {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入你的用户名");
            String user_name = sc.nextLine();
            System.out.println("请输入你的密码");
            String user_pwd = sc.nextLine();
            if (name.equals(user_name) && pwd.equals(user_pwd)) {
                System.out.println("登录成功！");
                break;
            } else {
                if ((2 - count) == 0){
                    System.out.println("登录失败，请重启系统！");
                }else {
                    System.out.println("登陆失败，你还有：（" + (2 - count) + ")次机会");
                }
            }

        }
    }
}
