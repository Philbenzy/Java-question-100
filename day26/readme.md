

## JavaDay26 网络编程

（1）InetAddress类

（2）网络编程要素

（3）Socket

（4）UDP发送数据

（5）TCP发送数据

### 1-InetAddress类

InetAddress类的构造方法被私有，它的成员方法全都是静态的；

最常使用public static InetAddress getByName(String host)来获取地址对象，可以传入IP地址、或者主机名称；

InetAddress类可以获取两个东西：getHostName()主机名称、getHostAddress()获取IP地址；

```java
InetAddress address = InetAddress.getByName("Laptop"); 

String name = address.getHostName();
String ip = address.getHostAddress();

System.out.println(name + "---" + ip);
```

### 2-网络编程要素

（1）IP地址：IP的分类、IP地址查询命令、IP组成；

（2）端口号：范围在0-65535，0-1024为系统使用；

（3）通信协议（TCP/UDP）：两种不同的通信协议对应不同效率的通信；

### 3-Socket

- Socket对象在通信两端都应该存在
- Socket之间使用IO流进行数据的传输
- TCP使用的Socket与UDP使用的Socket不同

注意：UDP使用的是DatagramSocket进行传输，TCP使用的是Socket与ServerSocket进行传输

### 4-UDP发送与接收数据

UDP发送数据的流程如下：

（1）使用DatagramSocket创建Socket对象；

（2）确定需要写入的数据；

（3）打包数据（数据内容、数据长度、发送地址、端口号）；

（4）调用Socket对象的发送方法；

（5）释放资源；

案例演示：

```java
// 发送端

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

        // 3打包
        DatagramPacket dp = new DatagramPacket(bys,length,address,port);

        // 4发送
        ds.send(dp);
        ds.close();
    }
}
```

UDP接收数据的流程如下：

（1）创建UDP的Socket对象DatagramSocket

（2）创建接收数据包

（3）调用Socket接收方法

（4）解析数据

（5）释放资源

```java
// 接收端

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
```

### 5-TCP发送与接收数据

TCP发送数据流程

（1）创建TCP客户端Socket对象Socket

（2）获取输入流，写入数据

（3）释放资源

```java
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
```

TCP接收数据流程

（1）创建TCP服务端ServerSocket

（2）监听客户端连接

（3）获取输入流并读取数据

（4）释放资源

```java
//TCP接收
public class MyServer {
    public static void main(String[] args) throws IOException {
        // (1)创建Socket对象
        ServerSocket ss = new ServerSocket(12306);

        // （2）链接
        Socket s = ss.accept(); // 阻塞方法

        // (3)获取输入流并解析
        InputStream is = s.getInputStream();

        byte[] bys = new byte[1024]; // 读取大小
        int length = is.read(bys);// 读取长度
        String string = new String(bys,0,length);
        String ip = s.getInetAddress().getHostAddress();
        System.out.println(ip+":"+string);
        
        // （4）释放资源
        s.close();
    }
}
```

### 6-其他案例

- 案例演示1：服务器发送给客户端收到命令「package test4」
- 案例演示2：键盘录入数据并让服务端读取「package test5;」
- 案例演示3：客户端读取文件，上传进入服务端，由服务端拷贝，返回给客户端上传成功「package test6;」

一个方法shutdownOutput()的由来：readLine()方法原来为阻塞式方法，读取文件最末端没有内容时返回null，但使用readLine()方法读取在服务端与客户端存在的流对象时，当没有数据后，并不会返回null，此时，方法仍然阻塞，服务器保持读取阻塞状态，所以，一个新的方法shutdownOutput();可以由客户端发送给服务端，之后服务端收到了关闭流命令，服务端结束读取流，执行向客户端发送信息的命令；



