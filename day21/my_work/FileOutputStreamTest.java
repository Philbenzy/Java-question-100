package my_work;

// ���µİ汾��ʵ���ֽ�����ȡ����

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileOutputStreamTest {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("code/day21_IO/a.txt");


        int len = 0;
        while ((len=fis.read())!=-1){
            System.out.print((char)len);
        }

        fis.close();
    }
}
