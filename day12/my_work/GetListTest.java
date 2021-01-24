/*
 * 从数组转换到列表打印的过程
 * */
package my_work;

public class GetListTest {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        String s = "";
        s += "[";
        for (int x = 0; x < arr.length; x++) {
            if (x == arr.length - 1) {
                s += arr[x];
                s += "]";
            } else {
                s += arr[x];
                s += " ,";
            }
        }
        System.out.println("最终拼接的结果为：" + s);
        System.out.println("使用方法最终拼接的结果为：" + arrayToString(arr));
    }


    public static String arrayToString(int[] arr) {
        String s = "";
        s += "[";
        for (int x = 0; x < arr.length; x++) {
            if (x == arr.length - 1) {
                s += arr[x];
                s += "]";
            } else {
                s += arr[x];
                s += " ,";
            }
        }
        return s;
    }
}
