package my_work;

import java.io.*;

public class RandomAccessFileToReadAndWrite {
    public static void main(String[] args) throws IOException {


        write();
        read();


        //raf.close();
    }

    private static void write() throws IOException{
        RandomAccessFile raf = new RandomAccessFile("MyArray.txt","rw");

        // 随机文件写入类
        raf.writeInt(100);
        //raf.writeUTF("中国");
        raf.writeUTF("中国");
        raf.writeFloat(32.1F);
        raf.writeBoolean(true);
        raf.close();
    }

    public static void read()throws IOException{
        RandomAccessFile raf = new RandomAccessFile("MyArray.txt","rw");
        // 读取方法
        int i = raf.readInt();
        System.out.println(i);

        String s = raf.readUTF();
        System.out.println(s);

        float f = raf.readFloat();
        System.out.println(f);

        Boolean b = raf.readBoolean();
        System.out.println(b);
    }
}
