public class reserve {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        fanZhuan(arr);
        bianLi(arr);
    }

    public static void fanZhuan(int[] arr) {
        for (int start = 0, end = arr.length - 1; start <= end; start++, end--) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }
    }

    public static void bianLi(int[] arr) {
        System.out.print("["); // ¿ªÊ¼
        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length - 1) {
                System.out.print(arr[i] + ",");
            } else {
                System.out.println(arr[i] + "]"); // ½áÊø
            }
        }
    }
}