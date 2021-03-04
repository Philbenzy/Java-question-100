package test1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class MyReceiveDemo {
    public static void main(String[] args) throws IOException {
        // DatagramSocket(int port) 构造方法
        // （1）接收端
        DatagramSocket ds = new DatagramSocket(10086);

        // （2）创建接收数据包
        byte[] bys = new byte[1024];
        int length = bys.length;
        // DatagramPacket(byte[] buf, int length)
        DatagramPacket dp = new DatagramPacket(bys,length);

        //（3）接受
        ds.receive(dp);

        // 收到数据后，对数据进行解析
        // (4.1)解析主机信息
        InetAddress address = dp.getAddress();
        String ip = address.getHostAddress();

        // （4.2）解析内容信息
        byte[] bys2 = dp.getData();
        int length2 = bys2.length;
        String string = new String(bys2,0,length2);

        System.out.println(ip+": "+" 已收到数据："+string);
        // （5）关闭资源
        ds.close();
    }
}
