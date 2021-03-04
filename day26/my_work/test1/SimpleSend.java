package test1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class SimpleSend {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while ((line = br.readLine())!=null){
            if ("886".equals(line)){
                break;
            }

            byte[] bys = line.getBytes();
            //int length = bys.length;

            DatagramPacket dp = new DatagramPacket(bys, bys.length, InetAddress.getByName("10.34.15.72"),10086); // 信息，长度，地址，端口

            ds.send(dp);
        }
        ds.close();
    }
}
