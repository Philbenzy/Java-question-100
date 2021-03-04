package test4;
// 服务器发送给客户端收到命令

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(12306);

        Socket s = ss.accept();

        // 获取数据
        InputStream is = s.getInputStream();
        byte[] bys = new byte[1024];
        int length = is.read(bys);
        String str = new String(bys,0,length);
        System.out.println(str);
        // 发送数据
        OutputStream os = s.getOutputStream();
        os.write("已收到数据！".getBytes());

        s.close();
    }
}
