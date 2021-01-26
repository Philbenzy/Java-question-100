package my_work;

import java.util.Scanner;

public class StringSymmetry {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        StringBuffer sb = new StringBuffer();
        if (s.equals(sb.reverse().append(s).toString())){
            System.out.println("字符串是对称的！");
        }else{
            System.out.println("并不对称！");
        }
    }
}
