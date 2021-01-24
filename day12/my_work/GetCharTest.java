/*
 * 将String打印出[a, b, c, d, e]格式
 * 字符串功能：charAt() 表示使用索引得到需要的字符串
 * */

package my_work;

public class GetCharTest {
    public static void main(String[] args) {
        String s = "abcde";
        for (int x = 0; x < s.length(); x++) {
            char c = s.charAt(x);
            if (x == 0) {
                System.out.print("[" + c + ", ");
            } else if (x == s.length() - 1) {
                System.out.print(c + "]");
            } else {
                System.out.print(c + ", ");
            }
        }
    }
}


