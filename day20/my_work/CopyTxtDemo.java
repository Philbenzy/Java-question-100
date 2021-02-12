package my_work;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 创建某个流对象要做的事情
 * （1）将流对象指向具体文件
 * （2）启用流对象方法，写入或者读出
 * （3）执行完毕释放资源
 * */

public class CopyTxtDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("a.txt");
        FileOutputStream fos = new FileOutputStream("b.txt");

        int by = 0;

        while ((by = fis.read())!=-1){
            System.out.println("copy中，请勿打扰。。。");
            fos.write(by);
        }

        fos.close();
        fis.close();
    }
}
