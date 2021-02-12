package my_work;

import java.io.*;

/**
 * ��1�������ֽ�����һ�ζ�ȡһ���ֽ�,д���ļ�
 * ��2�������ֽ�����һ�ζ�ȡһ���ַ�����,д���ļ�
 * ��3����Ч�ֽ���(BufferedInputStream)��һ�ζ�ȡһ���ֽ�,д���ļ�
 * ��4����Ч�ֽ���(BufferedInputStream)��һ�ζ�ȡһ���ַ�����,д���ļ�
 *
 *              write(byte[] b, int off, int len)
 *           ��ָ�� byte �����д�ƫ���� off ��ʼ�� len ���ֽ�д����ļ��������*/

public class ForDifferentTypeIO {
    public static void main(String[] args) throws IOException {
        method1("a.txt","copy_form_a.txt");
        System.out.println("��ӡ��ɣ�");
    }


    // ����1�������ֽ���
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

    // ����2�������ֽ���+����
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

    // ����3����Ч�ַ���д��һ���ֽ�
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

    // �����ģ���Ч�ַ���д��+����
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

