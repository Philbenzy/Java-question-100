package my_work;

import java.util.Scanner;

public class Reverse {
    public static void main(String[] args) {
        String s1 = "";
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        s1 = myReverse(s);
        String s2 = myReverse2(s);
        System.out.println("s1:"+s1);
        System.out.println("s2:"+s2);

    }

    public static String myReverse(String s){
        StringBuffer sb = new StringBuffer();
        sb.append(s);
        sb.reverse();
        return sb.toString();
    }

    public static String myReverse2(String s){
        // ¾«¼ò°æ
        return new StringBuffer().append(s).reverse().toString();
    }


}
