package my_work;


import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamDemo2 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("my_work.txt");

        int len = 0;
        while ((len = fis.read())!=-1){
            System.out.println((char)len);
        }

        fis.close();
    }
}
