package my_work;
/**
 * Ĭ�ϵģ��ֻ�����һ�����1��ͷ
 * ��2���ڶ�λΪ[3568]����
 * ��3���ֻ����볤����11λ*/
public class CheckPhone {
    public static void main(String[] args) {
        String phoneNumber = "17712345678";
        String regex = "1[3568]\\d{9}";
        boolean result = phoneNumber.matches(regex);
        System.out.println("�Ƿ�Ϊ������Ҫ���ֻ����룿 "+result);
    }
}
