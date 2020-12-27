//数组查表法(根据键盘录入索引,查找对应星期)

import java.util.Scanner;
public class IndexFind {
    public static void main(String[] args) {
        String[] arr = {"星期一","星期二","星期三","星期四","星期五","星期六","星期日",};
        System.out.print("请输入你的索引(0-6)：");
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        System.out.println("索引的查找结果为："+arr[a]);
    }
}
