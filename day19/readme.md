## JavaDay19 异常与文件

（1）异常

（2）File类

### 1-异常

（1）异常体系

- Throwable：异常的顶层类
  - Error：严重错误，不进行处理
  - Exception：
    - RuntimeException：运行时期出现的异常，是程序不严谨造成的，可以不处理，也可以处理
    - 非RuntimeException：编译时期出现的异常，必须对问题进行处理，要么抛出，要么使用try-catch进行处理

（2）异常的处理方式

- JVM的默认处理方式，意味着将出现的问题抛出给了虚拟机
- 调用者使用try-catch对异常进行处理

（3）编译时期|运行时期异常的区别

- 编译时期：编译时期出现的异常被归为「非RuntimeException类」，必须要进行处理，处理方式有两种，要么使用throws继续抛出，要么使用try-catch进行处理。
- 运行时期：运行时期出现的异常被归为「RuntimeException类」，可以不处理。

（4）异常的try-catch-finally处理方式

- 单个异常处理方式1：

```JAVA
try{
	...;
}catch(异常名称 变量名称){
	针对问题的处理;
}finally{
	释放资源;
}
```

- 单个异常处理方式2：

```java
try{
	...;
}catch(异常名1 |异常名2|异常名3 变量){
	...;
}
// 这样进行处理异常时，如果在try中出现了多个异常，那么在catch中只会处理一个
// 异常之间应该改是平级的关系
```

- 多个异常出现时的处理方式1：

```java
// 写多个try-catch
try{
	...;
}catch(异常名称 变量名){
	...;
}catch(异常名称 变量名){
	...;
}
```

注意：如果捕获的异常是平级关系，那么顺序不重要，但是如果是父子级别类型的异常，父应该出现在最后

（5）throw与throws关键字

throw：

- 声明在方法体内，使用new关键字创建异常对象
- 表示抛出异常，可以得到一个实体的异常对象

throws：

- 声明在方法名称上，表示一种抛出异常的可能性，不一定会出现
- 后面可以接多个类型异常，异常名称使用逗号隔开
- 表示向外抛出异常，由方法的调用者处理

（6）finally关键字

finally关键字用于最后的释放资源，被finally修饰的语句一定会执行，但是如果在执行到了finally之间JVM退出了，那么就不能继续执行了；

（7）final、finally、finalize区别

- final关键字用于修饰成员变量、方法、类
  - 成员变量：变为常量，不可被重新赋值
  - 方法：不可被子类重写
  - 类：不能被继承
- finally表示最终的意思，属于异常处理的最后一步，用来释放资源
  - 如果catch里有return语句，那么finally里面的代码还会执行吗？例子如下：

```java
public class FinallyDemo2 {
   public static void main(String[] args) {
      System.out.println(getInt());
   }

   public static int getInt() {
      int a = 10;
      try {
         System.out.println(a / 0);
         a = 20;
      } catch (ArithmeticException e) {
         a = 30;
         return a;
         /*
          * return a在程序执行到这一步的时候，这里不是return a而是return 30;这个返回路径就形成了。
          * 但是呢，它发现后面还有finally，所以继续执行finally的内容，a=40
          * 再次回到以前的返回路径，继续走return 30;
          */
      } finally {
         a = 40;
         return a;//如果这样结果就是40了。
      }
      // return a;
   }
}
```

- finalize是Object类的一个方法，用于垃圾回收

（8）自定义异常

如果要自定义异常，那么就需要让这个类继承

- Exception
- RuntimeException

（9）异常与继承

- 父类抛出了异常，那么继承父类的子类抛出的异常 **>=** 父类的异常，子类不能抛出父类没有的异常
- 父类如果没有异常抛出，那么子类也不能抛出异常，如果还想处理只能使用try-catch-finally处理

### 2-File类

（1）File类的构造方法

*      File(String pathname)：根据一个路径得到File对象
*     File(String parent, String child):根据一个目录和一个子文件/目录得到File对象
*     File(File parent, String child):根据一个父File对象和一个子文件/目录得到File对象

（2）File类基本功能

- 创建功能：public boolean createNewFile():创建文件 如果存在这样的文件，就不创建了
- 删除功能：public boolean delete()：删除不走回收站
- 重命名功能：public boolean renameTo(File dest)：可以做到改名与剪贴
- 判断功能：
  - public boolean isDirectory():判断是否是目录
  - public boolean isFile():判断是否是文件
  - public boolean exists():判断是否存在
  - public boolean canRead():判断是否可读
  - public boolean canWrite():判断是否可写
  - public boolean isHidden():判断是否隐藏
- 获取功能
  - public String getAbsolutePath()：获取绝对路径
  - public String getPath():获取相对路径
  - public String getName():获取名称
  - public long length():获取长度。字节数
  - public long lastModified():获取最后一次的修改时间，毫秒值
- 高级获取功能
- 过滤器功能
  - public String[] list():获取指定目录下的所有文件或者文件夹的名称数组
  - public File[] listFiles():获取指定目录下的所有文件或者文件夹的File数组

（3）案例演示

- 输出指定目录下的指定后缀名文件
  - 获取-遍历-输出：案例演示「GetFilesName.java」
  - 使用FilenameFilter()得到：案例演示：「GetFilesName2.java」



