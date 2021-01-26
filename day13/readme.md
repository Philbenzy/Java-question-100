## JavaDay13常见对象

主要学习四个类：

**（1）StringBuffer；（2）Arrays工具类与数组两种查找；（3）Interger；（4）Character；**

### 1:StringBuffer(掌握)
   **(1)作用**

StringBuffer类被称为字符缓冲区，StringBuffer的出现是为了解决String类无法修改，StringBuffer类的作用是将字符串内容变得可以进行修改

   **(2)StringBuffer的构造方法**

​      A:StringBuffer()：无参构造

​      B:StringBuffer(int size)：指定容量的字符串缓冲区，默认会有16字节的大小

​      C:StringBuffer(String str)：指定字符串内容的初始化

   **(3)StringBuffer的常见功能**

​      A:添加功能

​			append(String str)：将任意类型数据加入缓冲区内，并返回字符串缓冲区本身；

​			insert(int offset String str)：指定位置插入；

​      B:删除功能

​			deleteCharAt(int index)：删除指定位置的字符串，返回本身；

​			delete(int start, int end)：删除指定长度的字符串，返回本身；

​      C:替换功能

​			replace(int start, int end, String str)：将xxx替换为xxx

​      D:反转功能

​			reverse()：反转字符串

​      E:截取功能(注意这个返回值)

​			String substring(int start)：返回一个String类型

​			String substring(int start, int end)：返回一个String类型

   **(4)StringBuffer的练习**

​      A：String和StringBuffer相互转换

String to buffer:

​			方法1：调用构造方法转换

```java
        StringBuffer sb = new StringBuffer(s);
        System.out.println("字符缓冲区类型:" + sb);
```

​     	   方法2：调用append方法完成

```java
        StringBuffer sb2 = new StringBuffer();
        sb2.append(s);
        System.out.println("字符缓冲区类型:" + sb2);
```

buffer to String：

​			方法1：调用buffer方法toString

```java
        String s2 = sb.toString();
        System.out.println("字符串类型：" + s2);
```

​			方法2：调用String构造

```java
        String s3 = new String(s);
        System.out.println("字符串类型"+s3);
```

​    			**案例演示：「StringAndBuffer.java」** 

​	 B:字符串的拼接

​			字符串的拼接使用StringBuffer的append方法完成拼接

​      C:把字符串反转

​			字符串的反转可以使用StringBuffer中的reserve方法进行反转

​			**案例：「Reverse.java」**

​      D:判断一个字符串是否对称

​			**案例：「StringSymmetry.java」**

   **(5)思考题**

​	**小细节：**

​         StringBuffer：同步的，数据安全，效率低。

​         StringBuilder：不同步的，数据不安全，效率高。

​      **A:String,StringBuffer,StringBuilder的区别**

​			1：String与StringBuffer和StringBuilder的区别：

​			前者一旦固定后，就不能对内容进行修改，而后两者可以对内容进行再次修改；

​			2：StringBuffer与StringBuilder的区别：

​			StringBuffer与StringBuilder的区别在于，buffer是线程安全型，builder的效率更高，一般使用builder更多一些。

​      **B:StringBuffer和数组的区别?**

​			StringBuffer中，你可以传入不同类型的内容，int floate byte string boolena 等，他们都会被当作字符串对待，而在数组中只能保存相同类型的数据。

   **(6)注意的问题：**

​      String作为形式参数，StringBuffer作为形式参数

```java
package cn.itcast_08;

/*
 * 
 * 形式参数问题
 * String作为参数传递
 * StringBuffer作为参数传递 
 * 
 * 形式参数：
 * 		基本类型：形式参数的改变不影响实际参数
 * 		引用类型：形式参数的改变直接影响实际参数
 * 
 * 注意：
 * 		String作为参数传递，效果和基本类型作为参数传递是一样的。
 */
public class StringBufferDemo {
	public static void main(String[] args) {
		String s1 = "hello";
		String s2 = "world";
		System.out.println(s1 + "---" + s2);// hello---world
		change(s1, s2);
		System.out.println(s1 + "---" + s2);// hello---world

		StringBuffer sb1 = new StringBuffer("hello");
		StringBuffer sb2 = new StringBuffer("world");
		System.out.println(sb1 + "---" + sb2);// hello---world
		change(sb1, sb2);
		System.out.println(sb1 + "---" + sb2);// hello---worldworld

	}

	public static void change(StringBuffer sb1, StringBuffer sb2) {
		sb1 = sb2;
		sb2.append(sb1);
	}

	public static void change(String s1, String s2) {
		s1 = s2;
		s2 = s1 + s2;
	}
}
```

String作为参数传递：

​	在方法change()中，不管如何交换，最终打印出来的结果还是本身，这就说明方法拿出来的是基本类型的内容，而不是指向地址；所以怎么修改打印的结果都不发生变化

StringBuffer作为参数传递：

​	这里传入的是一个引用类型的对象，直接指向地址值，在方法内部变化的同时，也在外部跟随变化，所以change(sb1, sb2);之后打印出的结果是hello---worldworld

### 2:数组高级以及Arrays(掌握)
   **(1)排序**

​      A:冒泡排序

​			**案例演示：「ArraySortDemo.java」**

​      B:选择排序

​			**案例演示：「ArraySearchDemo.java」**

   **(2)查找**

​      A:基本查找

​         针对数组无序的情况

​    **B:二分查找(折半查找)**

​         针对数组有序的情况(千万不要先排序，在查找)

​		 **案例演示：「BinarySearch.java」**

   **(3)Arrays工具类**

​      A:是针对数组进行操作的工具类。包括排序和查找等功能。

​      B:方法

​         把数组转成字符串：

​			- Arrays.toString(int[] arr)方法

​         排序：

​			- Arrays.sort(int[ ] a)

​         二分查找：

​			- binarysearch(int[ ] a, int key)

   **(5)把字符串中的字符进行排序**
      举例：
         "edacbgf"
         得到结果
         "abcdefg"

​		（1）将字符串转换为字符数组

​		（2）对字符数组进行排序

​		（3）将排序结果由字符数组再转换为字符串

### 3:Integer(掌握)
   **(1)为了让基本类型的数据进行更多的操作，Java就为每种基本类型提供了对应的包装类类型**
      byte      Byte

​      short     Short

​      int          Integer

​      long       Long

​      float      Float

​      double    Double

​      char      Character

​      boolean       Boolean

   **(2)Integer的构造方法**
      A:Integer i = new Integer(100);

​      B:Integer i = new Integer("100");

​         注意：这里的字符串必须是由数字字符组成

   **(3)String和int的相互转换**
      A:String -- int

​         Integer.parseInt("100");

​      B:int -- String

​         String.valueOf(100);

   **(4)其他的功能(了解)**

​      进制转换

​		使用方法：Integer.toString(i, radix)

​		就可以将指定的10进制数字转换为指定进制

   **(5)JDK5的新特性**

​      自动装箱   基本类型--包装类型

​      自动拆箱   包装类型--基本类型

​      把下面的这个代码理解即可：

```java
Integer i = 100;// 完整的写法：integer i = int 100 两个不同类型做赋值运算，自动装箱为包装类型；
i += 200;// （1）先拆箱，将包装类转换为基本类型，再装箱，将基本类型转换为包装类型Interger
```

   **(6)面试题**
      -128到127之间的数据缓冲池问题

​			问题描述：向Integer()类型中传入（1）-128到127之间的值，（2）区间外的值，是否会有不同？

​			回答：会有不同情况，如果传入的值在区间内，则直接从缓冲池进行获取，如果在区间外部，则需要重新开辟内存地址获取，通过使用"=="判断内存地址可以明确这个问题。

### 4:Character(了解)
   **(1)Character构造方法** 

​      Character ch = new Character('a');

   **(2)要掌握的方法：(自己补齐)**

​      A:判断给定的字符是否是大写

​			public static boolean isUpperCase(char ch)：

​      B:判断给定的字符是否是小写

​			public static boolean isLowerCase(char ch):

​      C:判断给定的字符是否是数字字符

​			public static boolean isDigit(char ch)

​      D:把给定的字符转成大写

​			public static char toUpperCase(char ch)

​      E:把给定的字符转成小写

​			public static char toLowerCase(char ch)

   **(3)案例：**
      统计字符串中大写，小写及数字字符出现的次数

​		**案例：「StringTimeDemo.java」**