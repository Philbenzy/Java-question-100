/*
 * ��String��ӡ��[a, b, c, d, e]��ʽ
 * �ַ������ܣ�charAt() ��ʾʹ�������õ���Ҫ���ַ���
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


