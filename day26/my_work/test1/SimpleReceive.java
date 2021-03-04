package test1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class SimpleReceive {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket(10086);
        while (true){
            byte[] bys = new byte[1024];
            DatagramPacket dp = new DatagramPacket(bys,bys.length);

            ds.receive(dp);

            String ip = dp.getAddress().getHostAddress();
            String string = new String(dp.getData(),0,dp.getLength());

            System.out.println(ip+"发送的数据为："+string);
        }
        //ds.close();
    }
}
