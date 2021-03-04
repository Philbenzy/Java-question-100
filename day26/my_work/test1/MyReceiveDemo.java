package test1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class MyReceiveDemo {
    public static void main(String[] args) throws IOException {
        // DatagramSocket(int port) ���췽��
        // ��1�����ն�
        DatagramSocket ds = new DatagramSocket(10086);

        // ��2�������������ݰ�
        byte[] bys = new byte[1024];
        int length = bys.length;
        // DatagramPacket(byte[] buf, int length)
        DatagramPacket dp = new DatagramPacket(bys,length);

        //��3������
        ds.receive(dp);

        // �յ����ݺ󣬶����ݽ��н���
        // (4.1)����������Ϣ
        InetAddress address = dp.getAddress();
        String ip = address.getHostAddress();

        // ��4.2������������Ϣ
        byte[] bys2 = dp.getData();
        int length2 = bys2.length;
        String string = new String(bys2,0,length2);

        System.out.println(ip+": "+" ���յ����ݣ�"+string);
        // ��5���ر���Դ
        ds.close();
    }
}
