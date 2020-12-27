public class FindMax {
    public static void main(String[] args) {
        int x = 5;
        int y = 6;
        int max = showMax(x,y);
        System.out.println(max);
    }

    public static int showMax(int a, int b) {
        return (a > b) ? a : b;
    }
}

