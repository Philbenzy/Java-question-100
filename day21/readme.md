## JavaDay21 IO流（2）

本节学到的知识涉及

（1）字符流

（2）字节流

### 字符流

- 字符流的目的在于，字节流操作中文并不方便，所以出现了转换流，将字节流转换为字符流。

- 转换流是一个字符流，字符流 =  字节流 + 编码表

- 编码与解码的问题

  - 编码：String -- byte[ ]
  - 解码：byte[ ] -- String

- 字符流中需要编码的API接口

  - OutputStreamWriter
    - OutputStreamWriter(OutputStream os)
    - OutputStreamWriter(OutputStream os,**String charsetName**)
  - InputStreamReader
    - InPutStreamReader(InputStream is)
    - InputStreamReader(InputStream is, String **charsetName**)

- 字符流

  - Reader

    - InputStreamReader：转换流
      - FileReader：简写

    ```java
    InputStreamReader isr = new InputStreamReader(new FileInputStream(String s))// 由字节流转换为字符流
    FileReader fr = new FileReader(String s)// 完成了相同的操作，writer类同理
    ```

    - BufferedReader

  - Writer

    - OutputStreamWriter：转换流
      - FileWriter：
    - BufferedWriter

- 复制文本的5种方式

```java
package my_work;

import java.io.*;

public class FiveWayToCopyString {
    public static void main(String[] args) throws IOException {
        String srcString = new String("code/day21_IO/a.txt");
        String desString = new String("code/day21_IO/my_work.txt");

        //method1(srcString,desString);
        //method2(srcString, desString);
        //method3(srcString, desString);
        method5(srcString, desString);
    }

    // 方式5：使用BufferedReader的特有方法readLine与newLine
    private static void method5(String srcString, String desString) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(srcString));
        BufferedWriter bw = new BufferedWriter(new FileWriter(desString));

        String line = null;
        while ((line = br.readLine()) != null){
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

        br.close();
        bw.close();


    }


    // 方式4：使用BufferedReader字符流，一次读取一个字符数组
    private static void method4(String srcString, String desString) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(srcString));
        BufferedWriter bw = new BufferedWriter(new FileWriter(desString));

        char[] chs = new char[1024];
        int len = 0;
        while ((len = br.read(chs)) != -1) {
            bw.write(chs, 0, len);
        }

        br.close();
        bw.close();
    }


    // 方式3：使用BufferedReader读取数据，每次一个字节
    private static void method3(String srcString, String desString) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(srcString));
        BufferedWriter bw = new BufferedWriter(new FileWriter(desString));

        int len = 0;
        while ((len = br.read()) != -1) {
            bw.write(len);
        }
        br.close();
        bw.close();

    }


    // 方式1：使用字符流FileWriter读取数据，每次一个字节
    private static void method1(String srcString, String desString) throws IOException {

        FileReader fr = new FileReader(srcString);
        FileWriter fw = new FileWriter(desString);

        int ch = 0;
        while ((ch = fr.read()) != -1) {
            fw.write(ch);
        }

        fw.close();
        fr.close();
    }

    // 方式2：使用FileReader读取数据，每次自定义大小
    private static void method2(String srcString, String desString) throws IOException {
        FileReader fr = new FileReader(srcString);
        FileWriter fw = new FileWriter(desString);

        int len = 0;
        char[] by = new char[1024];
        while ((len = fr.read(by)) != -1) {
            fw.write(by, 0, len); // 数据大小，数据长度
            fw.flush();
        }
        fw.close();
        fr.close();
    }

}
```

### 2 IO流小结

IO流

- 字节流
  - 输入流InputStream；int Read()一次读取一个字节；int Read(byte[ ] bys)一次读取一个字符数组
    - FileInputStream
    - BufferedInputStream
  - 输出流OutPutStream；void write(int by)一次写入一个字节；void write(byte[ ] bys, int index, int len);一次写入一个字节数组的一部分；
    - FileOutputStream
    - BufferedOutputStream

- 字符流

  - 输入流 Reader
    - InputStreamReader
      - FileReader
    - BufferedReader（高效读入类）
      - 特有方法：String readLine()一次读取一行
  - 输出流 Writer
    - OutputStreamWriter
      - FileWriter
    - BufferedWriter（高效写入类）
      - 特有方法：void newLine()：写一个换行符
      - 特有方法：void write(String line)：一次写一个字符串

  

### 3:IO案例
（1）复制文本文件 5种方式

「FiveWayToCopyString.java」

（2）复制图片(二进制流数据) 4种方式

（3）把集合中的数据存储到文本文件

（4）把文本文件中的数据读取到集合并遍历集合

（5）复制单级文件夹

（6）复制单级文件夹中指定的文件并修改名称

​      回顾一下批量修改名称

（7）复制多级文件夹

「MyCopyFolder.java」

（8）键盘录入学生信息按照总分从高到低存储到文本文件

（9）把某个文件中的字符串排序后输出到另一个文本文件中

（10）用Reader模拟BufferedReader的特有功能

（11）模拟LineNumberReader的特有功能