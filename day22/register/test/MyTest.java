package register.test;

import register.dao.UserDao;
import register.dao.impl.UserDaoImpl;
import register.pojo.User;

import java.util.Scanner;

/**
 * 这是一个测试类，用于测试
 * （1）用户登录
 * （2）用户注册
 * （3）登陆成功提示是否进行游戏*/
public class MyTest {
    public static void main(String[] args) {
        while(true){
            System.out.println("- - - - 用户登录页面 - - - -");
            System.out.println("- - - - 1：用户注册 - - - - ");
            System.out.println("- - - - 2：用户登录 - - - - ");
            System.out.println("- - - -   3：退出  - - - - ");
            System.out.println();
            System.out.println();
            System.out.println("请选择你的输入");

            Scanner sc = new Scanner(System.in);

            UserDao ud = new UserDaoImpl();

            String choice = sc.nextLine();
            switch (choice){
                case "1":
                    System.out.println("- - - - 1：用户注册 - - - - ");
                    System.out.println("请输入用户名");
                    String userName = sc.nextLine();
                    System.out.println("请输入用户密码");
                    String userPassword = sc.nextLine();

                    // 将信息封装为对象
                    User user = new User();
                    user.setName(userName);
                    user.setPassword(userPassword);
                    ud.register(user);
                    System.out.println("用户注册完成！");
                    break;

                case"2":
                    System.out.println("请输入用户姓名：");
                    String name = sc.nextLine();
                    System.out.println("请输入用户密码：");
                    String password = sc.nextLine();

                    boolean flag = ud.isLogin(name,password);
                    if (flag){
                        System.out.println("游戏环节，你要来吗？y/n");
                        while (true){
                            String gameChoice = sc.nextLine();
                            if (gameChoice.equalsIgnoreCase("y")){
                                cn.itcast_08.GuessNumber.start();
                                System.out.println("你还玩吗？y/n");
                            }else {
                                break;
                            }
                        }

                    }else {
                        System.out.println("用户登陆失败");
                    }
                case"3":
                    System.out.println("欢迎下次再来！");
                    System.exit(0);
                    break;
            }
        }
    }
}
