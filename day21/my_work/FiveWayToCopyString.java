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

    // ��ʽ5��ʹ��BufferedReader�����з���readLine��newLine
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


    // ��ʽ4��ʹ��BufferedReader�ַ�����һ�ζ�ȡһ���ַ�����
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


    // ��ʽ3��ʹ��BufferedReader��ȡ���ݣ�ÿ��һ���ֽ�
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


    // ��ʽ1��ʹ���ַ���FileWriter��ȡ���ݣ�ÿ��һ���ֽ�
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

    // ��ʽ2��ʹ��FileReader��ȡ���ݣ�ÿ���Զ����С
    private static void method2(String srcString, String desString) throws IOException {
        FileReader fr = new FileReader(srcString);
        FileWriter fw = new FileWriter(desString);

        int len = 0;
        char[] by = new char[1024];
        while ((len = fr.read(by)) != -1) {
            fw.write(by, 0, len); // ���ݴ�С�����ݳ���
            fw.flush();
        }
        fw.close();
        fr.close();
    }

}
