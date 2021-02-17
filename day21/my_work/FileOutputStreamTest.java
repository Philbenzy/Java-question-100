package my_work;

// 出事的版本：实验字节流读取中文

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
