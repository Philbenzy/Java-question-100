package test3;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

// TCP
public class MyServer {
    public static void main(String[] args) throws IOException {
        // (1)����Socket����
        ServerSocket ss = new ServerSocket(12306);

        // ��2������
        Socket s = ss.accept(); // ��������

        // (3)��ȡ������������
        InputStream is = s.getInputStream();

        byte[] bys = new byte[1024]; // ��ȡ��С
        int length = is.read(bys);// ��ȡ����
        String string = new String(bys,0,length);
        String ip = s.getInetAddress().getHostAddress();
        System.out.println(ip+":"+string);

        // ��4���ͷ���Դ
        s.close();
    }
}
