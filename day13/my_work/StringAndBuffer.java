package my_work;

public class StringAndBuffer {
    public static void main(String[] args) {
        String s = "wzy";
        // String to buffer ����1�����ù��췽��ת��
        StringBuffer sb = new StringBuffer(s);
        System.out.println("�ַ�����������:" + sb);

        // buffer to String ����1������buffer�������з�ת
        String s2 = sb.toString();
        System.out.println("�ַ������ͣ�" + s2);

        //String to buffer ����2������append�������
        StringBuffer sb2 = new StringBuffer();
        sb2.append(s);
        System.out.println("�ַ�����������:" + sb2);

        // buffer to String ����2�����ù��췽��
        String s3 = new String(s);
        System.out.println("�ַ�������"+s3);

    }
}
