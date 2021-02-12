## JavaDay20 IO流-(1)

这次分享的是两类知识

（1）递归

（2）IO流

### 1-递归

（1）方法中调用方法本身

**递归**需要与**方法嵌套**作区分，例如「Math.max(Math.max(1, 2), 3)」就是函数嵌套。

如何分区递归与方法嵌套？

回答：**函数嵌套强调的是语言特性，递归调用强调的是逻辑思想。**

（2）递归注意事项

- 递归需要出口条件
- 递归需要放置内存溢出
- 构造方法中不能使用递归

（3）案例演示：「输出某种类型的字符目录」「斐波那契数列FibNumberList.java」

```java
// 1-斐波那契数列求和
package my_work;

public class FibNumberList {
    public static void main(String[] args) {
        
        int result = fib(20); // 6765
        System.out.println(result);
    }

    public static int fib(int num) {
        if (num == 1 || num == 2) { // 出口条件
            return num = 1;
        } else {
            return fib(num - 1) + fib(num - 2);
        }
    }
}
```

```java
// 2-输出名为txt的字符串
package my_work;

import java.io.File;

public class GetAllJavaFileName {
    public static void main(String[] args) {

        File fileBasicPath = new File("C:\\Users\\Wzy\\My_work\\zy_Javase\\刘意Java\\配套资料\\day20");

        method(fileBasicPath);
    }

    public static void method(File file){
        // 获取当前所有对象
        File[] fileArray = file.listFiles();

        for (File f : fileArray){
            if (f.isDirectory()){
                method(f); // 递归的开始
                System.out.println(f.getName());
            }else {
                if (f.getName().endsWith(".java")||f.getName().endsWith(".class")||f.getName().endsWith(".txt")){
                    System.out.print("\t");
                    System.out.print("| --- ");
                    System.out.println(f.getName());
                }
            }
        }
    }
}
```

### 2-IO流

（1）IO分类

总体设计：

- 字节流
  - FileInputStream
  - FileOutputStream
- 字符流
  - FileWriter
  - FileReader

注意IO流的读写方法read与writer：

**read()：**

- int read()	一次读取一个字节，返回值0-255或者-1
- int read(byte[ ]  b)  从此输入流中将最多 `b.length` 个字节的数据读入一个 byte 数组中
- int read(byte[ ] b, int off, int len)从此输入流中将最多 `len` 个字节的数据读入一个 byte 数组中

注意：**read()方法返回非-1的返回值只是表示后面还有数据，而不是表示读取了多少个数据**

**write()：**

- void write(int b)将指定字节写入此文件输出流

- void write(byte[ ] b) 将 `b.length` 个字节从指定 byte 数组写入此文件输出流中
- void write(byte[ ] b, int off, int len)将指定 byte 数组中从偏移量 `off` 开始的 `len` 个字节写入此文件输出流

（2）使用FileOutputStream写出数据

- A：创建流对象，指向具体文件路径
- B：调用write( )方法，写入字节流
- C：调用close( )方法，关闭流对象

代码演示：

```java
public class FileOutputStreamDemo {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("my_work.txt");
        fos.write("Hello,Java".getBytes());
        fos.close();
    }
}
```

（3）FileOutputStream需要注意的问题

- 创建字节输出流对象做了几件事情？

做了3件事情，如上。

- 为什么需要close()？

当进行完了读写操作之后，需要让流对象变成垃圾，被垃圾回收器回收；通知系统去释放与文件相关的资源；

- 如何实现数据换行？

windows通过「/n」实现

- 如何实现数据追加？

了解构造方法FileOutputStream(File file, boolean append)，中将第二个参数设置为true即可

（4）使用FileInputStream读取数据

- A：创建字节输入流对象
- B：调用read( )方法
- C：释放资源

代码演示：

```java
package my_work;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamDemo2 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("my_work.txt");

        int len = 0;
        while ((len = fis.read())!=-1){
            System.out.println((char)len);
        }

        fis.close();
    }
}
```

```java
byte[] bys = new byte[1024];
int len = 0;
while((len=fis.read(bys))!=-1) {
System.out.print(new String(bys,0,len));
}
fis.close();
```

（5）一个包装类对象，BufferedInputStream与BufferedOutputStrea，缓冲区读写

为了增加读写进行的效率，应用程序就可以将各个字节写入底层输出流中，而不必针对每次字节写入调用底层系统。 

（6）案例演示：「使用4中不同方式进行txt文件复制」

「ForDifferentTypeIO.java」

```java
package my_work;

import java.io.*;

/**
 * （1）基本字节流，一次读取一个字节,写入文件
 * （2）基本字节流，一次读取一个字符数组,写入文件
 * （3）高效字节流(BufferedInputStream)，一次读取一个字节,写入文件
 * （4）高效字节流(BufferedInputStream)，一次读取一个字符数组,写入文件
 *
 *              write(byte[] b, int off, int len)
 *           将指定 byte 数组中从偏移量 off 开始的 len 个字节写入此文件输出流。*/

public class ForDifferentTypeIO {
    public static void main(String[] args) throws IOException {
        method4("a.txt","copy_form_a.txt");
        System.out.println("打印完成！");
    }


    // 方法1：基本字节流
    private static void method1(String src, String des) throws IOException {

        FileInputStream fis = new FileInputStream(src);
        FileOutputStream fos = new FileOutputStream(des);

        int len = 0;
        while ((len = fis.read())!=-1){ // 调用默认构造方法，一次读取一个字节
            fos.write(len); // 默认写入方法，一次写入一个字节
        }

        fos.close();
        fis.close();

    }

    // 方法2：基本字节流+数组
    private static void method2(String src, String des) throws IOException{
        FileInputStream fis = new FileInputStream(src);
        FileOutputStream fos = new FileOutputStream(des);

        byte[] by = new byte[1024];
        int len = 0;

        while ((len = fis.read(by))!=-1){ // 调用带参构造，一次读入by大小的字节数组
            fos.write(by,0,len);// 调用带参构造，一次写入by大小的字节数组，0-len大小是为了读取内容不到整个大小的by数组时，防止后续内容重复。
        }

        fos.close();
        fis.close();
    }

    // 方法3：高效字符流写入一个字节
    private static void method3(String src, String des)throws IOException{

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(des));

        int len = 0;

        while ((len = bis.read())!=-1){ // 无参构造
            bos.write(len); // 无参构造
        }
        bis.close();
        bos.close();
    }

    // 方法四：高效字符流写入+数组
    private static void method4(String src, String des)throws IOException{
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(des));

        int len = 0;
        byte[] by = new byte[1024];
        while ((len=bis.read(by))!=-1){
            bos.write(by,0,len);
        }

        bos.close();
        bis.close();
    }
}
```





