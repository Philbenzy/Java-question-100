package my_work;

import java.util.Arrays;

public class StringSort {
    public static void main(String[] args) {
        String s = "acbefdg";
        // 转化为字符数组
        char[] arr  = s.toCharArray();
        // 调用方法排序
        Arrays.sort(arr);
        // 字符数组转换为字符串
        String result = String.valueOf(arr);
        System.out.println("排序结果："+result);

    }
}
