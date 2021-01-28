package my_work;

import java.util.Arrays;

/**
 * 我有如下一个字符串:"91 27 46 38 50"
 * 请写代码实现最终输出结果是："27 38 46 50 91"
 *
 *
 * 分析：
 * （1）使用分割split()方法进行分割，得到字符串数组
 * （2）字符串数组 to int数组
 * （3）int数组进行排序
 * （4）排序后使用StringBuilder输出
 * */

public class RegexDemo {
    public static void main(String[] args) {
        String s = "91 27 46 38 50";
        String regex = " ";
        String[] strArray = s.split(regex);

        int[] arr = new int[strArray.length];

        for (int x = 0; x<strArray.length;x++){
            arr[x] = Integer.parseInt(strArray[x]);
        }
        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for (int x=0; x< arr.length;x++){
            sb.append(arr[x]).append(" ");
        }

        // StringBuilder 转化为字符串,去空格
        String result = sb.toString().trim();
        System.out.println(result);
    }
}
