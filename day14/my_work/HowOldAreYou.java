package my_work;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class HowOldAreYou {
    public static void main(String[] args) throws Exception {
        System.out.println("��������ĳ�������:");
        Scanner sc = new Scanner(System.in);
        String youDay = sc.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // ���ַ������ݸ�ʽ����Ϊһ������
        Date yourMillions = sdf.parse(youDay);

        long getMillions = yourMillions.getTime(); //�õ����պ���ֵ

        long getNow = System.currentTimeMillis();// �õ����ڵĺ���ֵ

        long day = (getNow - getMillions) / 1000 / 60 / 60 / 24;
        System.out.println("�����������ϣ�" + day);


    }
}
