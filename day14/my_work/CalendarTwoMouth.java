package my_work;


import java.util.Calendar;
import java.util.Scanner;

public class CalendarTwoMouth {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        System.out.println("��������ݣ�");
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        cal.set(year,2,1);// ����������
        cal.add(Calendar.DATE,-1);// Calendar.Date��ʾ������ĳ�����е�һ��  // ƫ�����úõ�����
        System.out.println(cal.get(Calendar.DATE));// �õ���һ��
    }
}
