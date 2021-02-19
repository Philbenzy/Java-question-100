## JavaDay22 IO流（3）

本次接触到的知识点

（1）数据操作流（操作基本数据类型的流）

（2）内存操作流

（3）打印流

（4）System类中的标准输入流

（5）随机访问流

（6）合并流

（7）序列化流

（8）Properties

（9）NIO

（10）练习，使用IO流练习读取与登录玩猜数字游戏案例

### 1-数据操流Data

用来读写**基本数据类型**（String byte boolena char ...）的流

数据输入流：DataInputStream(InputStream in)

数据输出流：DataOutputStream(OutputStream out)

```java
DataOutputStream dos = new DataOutputStream(new FileOutputStream("dos.txt"));

// 写数据
dos.writeByte(10);
dos.writeShort(100);
dos.writeInt(1000);
dos.writeLong(10000);
dos.writeFloat(12.34F);
dos.writeDouble(12.56);
dos.writeChar('a');
dos.writeBoolean(true);
```

```java
DataInputStream dis = new DataInputStream(new FileInputStream("dos.txt"));

// 读数据
byte b = dis.readByte();
short s = dis.readShort();
int i = dis.readInt();
long l = dis.readLong();
float f = dis.readFloat();
double d = dis.readDouble();
char c = dis.readChar();
boolean bb = dis.readBoolean();
```

### 2-内存操作流

内存操作流主要的作用是用于临时存储信息到内存，程序结束就消失

（1）框架

分为三种：

- 字节数组
  - ByteArrayInputStream
  - ByteArrayOutputStream
- 字符数组
  - CharArrayReader
  - CharArrayWriter
- 字符数组
  - StringReader
  - StringWriter

注意：内存操作流中的close()方法，其实什么也没干；

### 3-打印流

（1）结构

- 打印流
  - 字符打印流PrintStream
  - 字节打印流PrintWriter

（2）特点

- 只可以进行数据的写入，对目的文件进行操作；
- 可以操作任意类型的数据「案例演示：PrintWriterDemo.java」
- 能够启动自动刷新，在调用println()方法的时候，不需要换行和flush
- 能够直接操作文本对象（构造方法中有String和File类参数，则可以直接操作文本对象）

（3）基本流与高级流

基本流：能够直接读取文件

高级流：在基本流基础上提供了进阶操作，如我们之前练习过的包装类，实现了特殊方法

（4）疑问：哪些流可以直接操作文本对象？

BufferedReader FileInputStream FileReader PrintStream PrintWriter

（5）使用PrintWriter复制文本文件

```java
BufferedReader br = new BufferedReader(new FileReader("a.txt"));
// 放弃了BufferedWriter的newline、flush写法
PrintWriter pw = new PrintWriter(new FileWriter("b.txt"),true);

String line = null;
while((line=br.readLine())!=null) {
   pw.println(line);
}

pw.close();
br.close();
```

### 4-标准输入输出流

（1）System类下的in和out

```java
// 之间，在Scanner类的学习中，我们这样写：
Scanner sc = new Scanner(System.in);

// 通过查询源码我们知道，System.in其实是一个静态方法，创建出了InputStream in = System.in；本质为一个字符流
// 目的，使用使用包装类包装System.in，方便调用readLine，如下：
BufferedReader br = new BufferedReader(new InputStreamReader(System.in))
br.readLine();
```

（2）Java键盘录入的三种方式

- main方法中的args接受参数
- 如上，通过BufferedReader进行包装
- 使用Scanner录入

### 5-随机访问流

可以按照文件指针的位置写数据和读数据。
（1）案例：RandomAccessFileToReadAndWrite.java

- 写数据
- 读数据

### 6-合并流

将多个输入流数据写入到一个输出流中

```
SequenceInputStream(InputStream s1, InputStream s2) 
SequenceInputStream(Enumeration<? extends InputStream> e) 
```

**Enumeration？**

Enumeration是Vector中的一个方法的返回值类型，所以如果需要使用第二个构造方法，那么就需要使用Vector集合的elements方法返回Enumeration



### 7-序列化流

可以把对象写入文本，或者在网络中进行传输

（1）如何实现序列化？

需要实现标记接口Serializable，具备序列化性

（2）注意问题

当写入数据到文件后，我们再修改了这个类，那么会如何呢？

回答：会不能进行读取操作，因为Class类 文本数据 read方法三者的id不匹配，读数据失败；

解决方法：

（1）重写数据进入文件

（2）使用transient关键词声明不需要序列化的成员变量

（3）自动产生一个固定的序列化id

### 8-Properties

（1）是一个集合类，Hashtable的子类，用来与IO流相结合使用

（2）特有功能

   A:public Object setProperty(String key,String value)：相当于put方法

   B:public String getProperty(String key)：得到键对应的值

   C:public Set\<String> stringPropertyNames()：得到键视图

（3）和IO流结合的方法

   把键值对形式的文本文件内容加载到集合中

   public void load(Reader reader)

   public void load(InputStream inStream)

   把集合中的数据存储到文本文件中

   public void store(Writer writer,String comments)

   public void store(OutputStream out,String comments)

（4）案例

- 根据给定的文件判断是否有键为"wangziyu"的，如果有就修改其值为1001：「MyPropertiesDemo.java」
- 使用Properties与IO结合写入数据与读取数据：「PropWithIO.java」

### 9-NIO

JDK4出现的NIO，对以前的IO操作进行了优化，提供了效率。但是大部分我们看到的还是以前的IO

（1）JDK7的NIO的使用 

- Path:路径
- Paths:public static Path get(URI uri)通过静态方法返回一个路径
- Files:提供了常见的功能
  - 复制文本文件
    - public static long copy(Path source,OutputStream out)
  - 把集合中的数据写到文本文件
    - public static Path write(Path path,Iterable<? extends CharSequence> lines,Charset cs,OpenOption... options)

（2）案例演示：Files.copy()复制文件

```java
Files.copy(Path.get("xxx.txt"),new FileOutputStream("copy.txt"))
```

（3）案例演示：Files.write()复制文件

```java
ArrayList<String> array = new ArrayList<String>();
array.add("hello");
array.add("world");
array.add("java");
Files.write(Paths.get("xxx.txt"), array, Charset.forName("UTF-8"));
```

### 10-使用IO流存储用户的录入信息

案例演示：「package register」

- dao
  - UserDao：定义了接口信息
  - package impl：如何实现
- game：猜数字小游戏
- pojo：存放用户类
- test：测试类（1）登录（2）注册

