package my_work;

public class MaxTheFirstChar {
    public static void main(String[] args) {
        String s = "wAnGziyU";
//         方法一：
//        String result = s.substring(0,1).toUpperCase().concat(s.substring(1).toLowerCase());
//        System.out.println(result);
        // 方法二：
        String smallAll = s.toLowerCase();
        String max = smallAll.substring(0,1).toUpperCase();
        String result = max + smallAll.substring(1);
        System.out.println(result);

    }
}
