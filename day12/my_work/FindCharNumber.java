package my_work;

import java.util.Scanner;

public class FindCharNumber {
    public static void main(String[] args) {
        int bigCount = 0;
        int smallCount = 0;
        int number = 0;

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        for (int x = 0; x < s.length(); x++) {
            char ch = s.charAt(x);
            if (ch >= 'a' && ch <= 'z') {
                smallCount++;
            }else if (ch>='A'&& ch <='Z'){
                bigCount++;
            }else {
                number++;
            }
        }

        System.out.println("小写字母有：（"+smallCount+"） 个");
        System.out.println("大写字母有：（"+bigCount+"） 个");
        System.out.println("数字有：（"+number+"） 个");

    }
}
