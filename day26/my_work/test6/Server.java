package test6;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        // (1)�����������Ự
        ServerSocket ss = new ServerSocket(12306);
        //��2������
        Socket s = ss.accept();
        //��3��������
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new FileWriter("Copy.txt"));

        // (4)д���ļ�
        String line = null;
        while ((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
            bw.flush();
        }
        bw.close();


        BufferedWriter bwServer = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        bwServer.write("�ϴ���ϣ�");
        bwServer.newLine();
        bwServer.flush();

        bwServer.close();
        s.close();
    }
}
