package my_work;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * ����ĳ��������Ҫ��������
 * ��1����������ָ������ļ�
 * ��2�����������󷽷���д����߶���
 * ��3��ִ������ͷ���Դ
 * */

public class CopyTxtDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("a.txt");
        FileOutputStream fos = new FileOutputStream("b.txt");

        int by = 0;

        while ((by = fis.read())!=-1){
            System.out.println("copy�У�������š�����");
            fos.write(by);
        }

        fos.close();
        fis.close();
    }
}
