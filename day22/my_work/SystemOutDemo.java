package my_work;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * �ַ�����ת������
 * ˵����
 * System.out ���� ��ʵ�Ǵ�����һ��PrintStream����
 *
 * Ҫ��
 * ��System.out��װ��Ϊһ����Ч�ַ���
 * */

public class SystemOutDemo {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write("���");
        bw.newLine();
        bw.write("��ò���");
        bw.newLine();
        bw.write("hellow");
        bw.newLine();
        bw.flush();
    }
}
