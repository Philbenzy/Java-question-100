package test1;

import java.io.IOException;
import java.net.*;

public class MySendDemo {
    public static void main(String[] args) throws IOException {
        // 1创建stock对象
        DatagramSocket ds = new  DatagramSocket();

        //2创建数据包
        byte[] bys = "hello,UDP,我来了,哈哈哈".getBytes();
        int length = bys.length;
        InetAddress address = InetAddress.getByName("10.34.15.72");
        int port = 10086;

        // DatagramPacket(byte[] buf, int length, InetAddress address, int port)
        // 3打包
        DatagramPacket dp = new DatagramPacket(bys,length,address,port);

        // 4发送
        ds.send(dp);
        ds.close();
    }
}
