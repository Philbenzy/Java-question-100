package test5;

import java.io.*;
import java.net.Socket;

// 键盘录入数据
public class MyClient {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("10.34.15.72",12306);

        // 键盘录入，并使用包装类传输
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        String line = null;

        while ((line = br.readLine())!=null){
            if ("over".equals(line)){
                break;
            }
            bw.write(line);
            bw.newLine();
            bw.flush();
        }
        s.close();

    }
}
