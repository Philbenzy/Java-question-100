package my_work;

import java.util.Arrays;

public class StringSort {
    public static void main(String[] args) {
        String s = "acbefdg";
        // ת��Ϊ�ַ�����
        char[] arr  = s.toCharArray();
        // ���÷�������
        Arrays.sort(arr);
        // �ַ�����ת��Ϊ�ַ���
        String result = String.valueOf(arr);
        System.out.println("��������"+result);

    }
}
