package test5;

import java.io.*;
import java.net.Socket;

// ����¼������
public class MyClient {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("10.34.15.72",12306);

        // ����¼�룬��ʹ�ð�װ�ഫ��
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
