package my_work;

import java.io.*;

public class FiveWayToCopyString {
    public static void main(String[] args) throws IOException {
        String srcString = new String("code/day21_IO/a.txt");
        String desString = new String("code/day21_IO/my_work.txt");

        //method1(srcString,desString);
        //method2(srcString, desString);
        //method3(srcString, desString);
        method5(srcString, desString);
    }

    // 方式5：使用BufferedReader的特有方法readLine与newLine
    private static void method5(String srcString, String desString) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(srcString));
        BufferedWriter bw = new BufferedWriter(new FileWriter(desString));

        String line = null;
        while ((line = br.readLine()) != null){
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

        br.close();
        bw.close();


    }


    // 方式4：使用BufferedReader字符流，一次读取一个字符数组
    private static void method4(String srcString, String desString) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(srcString));
        BufferedWriter bw = new BufferedWriter(new FileWriter(desString));

        char[] chs = new char[1024];
        int len = 0;
        while ((len = br.read(chs)) != -1) {
            bw.write(chs, 0, len);
        }

        br.close();
        bw.close();
    }


    // 方式3：使用BufferedReader读取数据，每次一个字节
    private static void method3(String srcString, String desString) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(srcString));
        BufferedWriter bw = new BufferedWriter(new FileWriter(desString));

        int len = 0;
        while ((len = br.read()) != -1) {
            bw.write(len);
        }
        br.close();
        bw.close();

    }


    // 方式1：使用字符流FileWriter读取数据，每次一个字节
    private static void method1(String srcString, String desString) throws IOException {

        FileReader fr = new FileReader(srcString);
        FileWriter fw = new FileWriter(desString);

        int ch = 0;
        while ((ch = fr.read()) != -1) {
            fw.write(ch);
        }

        fw.close();
        fr.close();
    }

    // 方式2：使用FileReader读取数据，每次自定义大小
    private static void method2(String srcString, String desString) throws IOException {
        FileReader fr = new FileReader(srcString);
        FileWriter fw = new FileWriter(desString);

        int len = 0;
        char[] by = new char[1024];
        while ((len = fr.read(by)) != -1) {
            fw.write(by, 0, len); // 数据大小，数据长度
            fw.flush();
        }
        fw.close();
        fr.close();
    }

}
