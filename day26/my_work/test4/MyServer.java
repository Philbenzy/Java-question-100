package test4;
// ���������͸��ͻ����յ�����

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(12306);

        Socket s = ss.accept();

        // ��ȡ����
        InputStream is = s.getInputStream();
        byte[] bys = new byte[1024];
        int length = is.read(bys);
        String str = new String(bys,0,length);
        System.out.println(str);
        // ��������
        OutputStream os = s.getOutputStream();
        os.write("���յ����ݣ�".getBytes());

        s.close();
    }
}
