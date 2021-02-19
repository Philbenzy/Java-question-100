package my_work;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * 字符流的转换功能
 * 说明：
 * System.out 功能 其实是创建了一个PrintStream对象
 *
 * 要求：
 * 把System.out包装成为一个高效字符流
 * */

public class SystemOutDemo {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write("你好");
        bw.newLine();
        bw.write("你好不好");
        bw.newLine();
        bw.write("hellow");
        bw.newLine();
        bw.flush();
    }
}
