package test3;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class MyClient {
    public static void main(String[] args) throws IOException {

        // ��1������Socket����
        Socket s = new Socket("10.34.15.72",12306);

        // ��2�������
        OutputStream os = s.getOutputStream();
        os.write("��ã�TCP,�����ˣ�".getBytes());
        //  ��3���ͷ���Դ
        s.close();

    }
}
