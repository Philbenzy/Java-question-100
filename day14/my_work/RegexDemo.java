package my_work;

import java.util.Arrays;

/**
 * ��������һ���ַ���:"91 27 46 38 50"
 * ��д����ʵ�������������ǣ�"27 38 46 50 91"
 *
 *
 * ������
 * ��1��ʹ�÷ָ�split()�������зָ�õ��ַ�������
 * ��2���ַ������� to int����
 * ��3��int�����������
 * ��4�������ʹ��StringBuilder���
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

        // StringBuilder ת��Ϊ�ַ���,ȥ�ո�
        String result = sb.toString().trim();
        System.out.println(result);
    }
}
