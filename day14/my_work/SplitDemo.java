package my_work;

import java.util.Scanner;

/**
 * ˵����
 * (1)����һ������ƥ���ֶΣ�ʹ��split()�����ָ����
 * (2)����¼��һ�����֣�ͨ���жϵõ��Ƿ���ָ��������
 */
public class SplitDemo {
    public static void main(String[] args) {
        String regex = "18-24";
        System.out.println("���������䣺");
        Scanner sc = new Scanner(System.in);
        int age = sc.nextInt();

        String[] strArray = regex.split("-");

        // ��String ת��Ϊ int ����
        int startAge = Integer.parseInt(strArray[0]);
        int endAge = Integer.parseInt(strArray[1]);
        if ((startAge <= age) && (age<=endAge)){
            System.out.println("����������ҵģ�");
        }else {
            System.out.println("������Ҫ��");
        }
    }
}
