package my_work;

// �Ӽ���¼�����֣���������0Ϊ������־����ӡ�������ֵ�����Ҵ�ӡ

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class RandomFromKeyboard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> list = new ArrayList<>();

        while (true){
            System.out.println("���������֣�������");
            int num = sc.nextInt();

            if (num!=0){
                list.add(num);
            }else {
                break;
            }
        }

        // ��ArrayListת��Ϊ���飬����ʹ�����鷽����������
        Integer[] i = new Integer[list.size()];

        // toArray() ������ Arraylist ����ת��Ϊ���顣
        list.toArray(i);

        // ����Array��̬������������
        Arrays.sort(i);

        // ��ӡ�ַ���
        System.out.println("�����ǣ�"+arrayToString(i)+"ͬʱ���������е����ֵΪ��"+i[i.length-1]);
    }

    public static String arrayToString(Integer[] i){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int x = 0;x < i.length;x++){
            if (x==i.length-1){
                sb.append(i[x]);
            }else {
                sb.append(i[x]).append(", ");
            }
        }
        sb.append("]");

        return sb.toString();
    }
}
