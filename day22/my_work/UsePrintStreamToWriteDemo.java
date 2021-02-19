package my_work;

import java.io.*;

/**
 * 使用打印流完成数据的写入
 * 说明：
 *      （1）BufferedReader与BufferedWriter的新方法，readLine与newLine*/
public class UsePrintStreamToWriteDemo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("name.txt"));

        // 原始写法
        // BufferedWriter bw = new BufferedWriter(new FileWriter("name_copy.txt"));

        PrintWriter pw = new PrintWriter(new FileWriter("name_copy.txt"),true);// 自动刷新

        String line = null;
        while ((line=br.readLine())!=null){
            // 打印流的println，不用newLine,不用flush
            pw.println(line);
        }

        br.close();
        pw.close();
    }
}
