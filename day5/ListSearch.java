import java.lang.reflect.Array;

public class ListSearch {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9};
        bianLi(arr);
    }
    public static void bianLi(int[] arr) {
        System.out.print("["); // ¿ªÊ¼
        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length - 1) {
                System.out.print(arr[i] + ",");
            } else {
                System.out.println(arr[i]+"]"); // ½áÊø
            }
        }
    }
}
