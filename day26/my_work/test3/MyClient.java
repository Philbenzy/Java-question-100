package test3;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class MyClient {
    public static void main(String[] args) throws IOException {

        // （1）创建Socket对象
        Socket s = new Socket("10.34.15.72",12306);

        // （2）输出流
        OutputStream os = s.getOutputStream();
        os.write("你好，TCP,我来了！".getBytes());
        //  （3）释放资源
        s.close();

    }
}
