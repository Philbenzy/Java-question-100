package my_work;

// 使用字符流读取中文

import java.io.*;

public class OutPutStreamWriter {
    public static void main(String[] args) throws IOException {
        //OutPutStreamRea osw = new OutPutStreamWriter(new FileOutputStream("code/day21_IO/a.txt"));
        InputStreamReader isr = new InputStreamReader(new FileInputStream("code/day21_IO/a.txt"));

        int ch = 0;
        while ((ch = isr.read())!=-1){
            System.out.print((char)ch);
        }

        isr.close();
    }
}
