package my_work;

public class FibNumberList {
    public static void main(String[] args) {

        int result = fib(20);
        System.out.println(result);
    }

    public static int fib(int num) {
        if (num == 1 || num == 2) {
            return num = 1;
        } else {
            return fib(num - 1) + fib(num - 2);
        }
    }

}
