package test4;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

//
public class MyClient {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("10.34.15.72",12306);

        // 写入数据
        OutputStream os = s.getOutputStream();
        os.write("你好呀，TCP".getBytes());

        //读数据
        InputStream is = s.getInputStream();
        byte[] bys = new byte[1024];
        int length = is.read(bys);

        String str = new String(bys,0,length);
        System.out.println(str);

        s.close();
    }
}
