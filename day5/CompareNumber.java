// B:判断两个数据是否相等
public class CompareNumber {
    public static void main(String[] args) {
        int x = 5;
        int y = 5;
        boolean flag = compareTwo(x, y);
        System.out.println(flag);
    }
    public static boolean compareTwo(int a, int b) {
        return a == b;
    }
}


