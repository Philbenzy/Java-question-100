package my_work;

import java.io.*;

/**
 * （1）基本字节流，一次读取一个字节,写入文件
 * （2）基本字节流，一次读取一个字符数组,写入文件
 * （3）高效字节流(BufferedInputStream)，一次读取一个字节,写入文件
 * （4）高效字节流(BufferedInputStream)，一次读取一个字符数组,写入文件
 *
 *              write(byte[] b, int off, int len)
 *           将指定 byte 数组中从偏移量 off 开始的 len 个字节写入此文件输出流。*/

public class ForDifferentTypeIO {
    public static void main(String[] args) throws IOException {
        method1("a.txt","copy_form_a.txt");
        System.out.println("打印完成！");
    }


    // 方法1：基本字节流
    private static void method1(String src, String des) throws IOException {

        FileInputStream fis = new FileInputStream(src);
        FileOutputStream fos = new FileOutputStream(des);

        int len = 0;
        while ((len = fis.read())!=-1){
            fos.write(len);
        }

        fos.close();
        fis.close();

    }

    // 方法2：基本字节流+数组
    private static void method2(String src, String des) throws IOException{
        FileInputStream fis = new FileInputStream(src);
        FileOutputStream fos = new FileOutputStream(des);

        byte[] by = new byte[1024];
        int len = 0;

        while ((len = fis.read(by))!=-1){
            fos.write(by,0,len);
        }

        fos.close();
        fis.close();
    }

    // 方法3：高效字符流写入一个字节
    private static void method3(String src, String des)throws IOException{

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(des));

        int len = 0;

        while ((len = bis.read())!=-1){
            bos.write(len);
        }
        bis.close();
        bos.close();
    }

    // 方法四：高效字符流写入+数组
    private static void method4(String src, String des)throws IOException{
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(des));

        int len = 0;
        byte[] by = new byte[1024];
        while ((len=bis.read(by))!=-1){
            bos.write(by,0,len);
        }

        bos.close();
        bis.close();
    }
}

