package test6;

import java.io.*;
import java.net.Socket;

// �ͻ��˶�ȡ�ļ����ϴ������������ȡ package10
public class Client {
    public static void main(String[] args) throws IOException {
        //(1)����Socket����
        Socket s = new Socket("10.34.15.72", 12306);
        // (2)д������
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Wzy\\My_work\\zy_Javase\\����Java\\��������\\day26\\code\\day26_Net\\a.txt"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

        String line = null;
        while ((line = br.readLine())!=null){
            bw.write(line);
            bw.newLine();
            bw.flush();
        }
        // (3)��ʾ������д�����
        s.shutdownOutput();
        // ��4����ȡ��������Ϣ
        BufferedReader brClient = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String str = brClient.readLine();

        System.out.println(str);

        br.close();
        s.close();
    }
}
