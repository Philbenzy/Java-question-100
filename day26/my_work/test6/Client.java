package test6;

import java.io.*;
import java.net.Socket;

// 客户端读取文件，上传进入服务器读取 package10
public class Client {
    public static void main(String[] args) throws IOException {
        //(1)创建Socket对象
        Socket s = new Socket("10.34.15.72", 12306);
        // (2)写入数据
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Wzy\\My_work\\zy_Javase\\刘意Java\\配套资料\\day26\\code\\day26_Net\\a.txt"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

        String line = null;
        while ((line = br.readLine())!=null){
            bw.write(line);
            bw.newLine();
            bw.flush();
        }
        // (3)提示服务器写入完成
        s.shutdownOutput();
        // （4）读取服务器信息
        BufferedReader brClient = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String str = brClient.readLine();

        System.out.println(str);

        br.close();
        s.close();
    }
}
