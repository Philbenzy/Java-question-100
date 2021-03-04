package test3;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

// TCP
public class MyServer {
    public static void main(String[] args) throws IOException {
        // (1)创建Socket对象
        ServerSocket ss = new ServerSocket(12306);

        // （2）链接
        Socket s = ss.accept(); // 阻塞方法

        // (3)获取输入流并解析
        InputStream is = s.getInputStream();

        byte[] bys = new byte[1024]; // 读取大小
        int length = is.read(bys);// 读取长度
        String string = new String(bys,0,length);
        String ip = s.getInetAddress().getHostAddress();
        System.out.println(ip+":"+string);

        // （4）释放资源
        s.close();
    }
}
