/*
 * 编写一个猜数字小游戏
 * 要求：数字出现在0-100以内
 */

import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args) {
        int answer = (int) (Math.random() * 100) + 1;

        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入你心里的数:");
            int guess = sc.nextInt();
            if (answer > guess) {
                System.out.println("你输入的数字" + guess + "偏小！");
            } else if (answer < guess) {
                System.out.println("你输入的数字" + guess + "偏大！");
            }else {
                System.out.println("你得到了正确答案："+answer);
                break;
            }
        }
    }
}


