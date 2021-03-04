package test6;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        // (1)创建服务器会话
        ServerSocket ss = new ServerSocket(12306);
        //（2）链接
        Socket s = ss.accept();
        //（3）流对象
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new FileWriter("Copy.txt"));

        // (4)写入文件
        String line = null;
        while ((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
            bw.flush();
        }
        bw.close();


        BufferedWriter bwServer = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        bwServer.write("上传完毕！");
        bwServer.newLine();
        bwServer.flush();

        bwServer.close();
        s.close();
    }
}
