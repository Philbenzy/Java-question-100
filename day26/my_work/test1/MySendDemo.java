package test1;

import java.io.IOException;
import java.net.*;

public class MySendDemo {
    public static void main(String[] args) throws IOException {
        // 1����stock����
        DatagramSocket ds = new  DatagramSocket();

        //2�������ݰ�
        byte[] bys = "hello,UDP,������,������".getBytes();
        int length = bys.length;
        InetAddress address = InetAddress.getByName("10.34.15.72");
        int port = 10086;

        // DatagramPacket(byte[] buf, int length, InetAddress address, int port)
        // 3���
        DatagramPacket dp = new DatagramPacket(bys,length,address,port);

        // 4����
        ds.send(dp);
        ds.close();
    }
}
