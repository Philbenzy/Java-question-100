package my_work;

import java.util.Scanner;

public class StringTimeDemo {
    public static void main(String[] args) {
        int small = 0;
        int big = 0;
        int number = 0;
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] chs = s.toCharArray();

        for (int x = 0; x<chs.length;x++){
            if (Character.isUpperCase(chs[x])){
                big++;
            }
            else if (Character.isLowerCase(chs[x])){
                small++;
            }
            else if(Character.isDigit(chs[x])){
                number++;
            }
        }
        System.out.println("���ֳ��֣� "+number+" Сд���֣� "+small+" ��д���֣�"+big);
    }
}
