## JavaDay12 String相关

### 1-Scanner的使用(了解)

1. **基本使用方法**

   （1）导包

   （2）创建对象

   （3）键盘录入

2. **常用格式Scanner sc = new Scanner(System.in); 讲解**

   在这个结构中，我们新建了一个键盘录入对象，为什么这么写呢？这就需要知道Scanner键盘录入对象的构造方法是怎么样的。

   首先看这个构造方法中传递的参数「System.in」，看他之前有一个小例子：

   ```java
   class Demo{
       public static final int x =1;
       public static final Student s = new student();
   }
   
   class Student{};
   
   class DemoTest{
       public static void main(String[] args){
           int y = Demo.x;	//	(1)
           Student s = Demo.s;	//	(2)
       }
   }
   ```

   （1） int y = Demo.x; 这是一个静态常量的创建，随着类的加载而加载，使用类名.对象名调用

   （2）Student s = Demo.s;	这是一个静态引用对象的创建，也会随着类的加载而加载，使用类名.对象名调用

   所以，「System.in」这样的方法，实际上在System类中存在一个静态的引用方法可以创建对象，之后，把这个仅有对象传递进Scanner类中，JVM自动调用了对应的构造方法进行录入！

### 2-String类的概述和使用(掌握)
1. **两个生成字符串方法的区别**

   A: 构造方法构造的对象：String s = new String("hello");

   B: 字面值构造对象：String s = "hello"；

   如图：

   ![image-20210124110140616](C:\Users\Wzy\AppData\Roaming\Typora\typora-user-images\image-20210124110140616.png)

   

   生成字符串的A方法中，会将常量储存在「方法区的字符串常量区域」，同时「堆内存内部地址」与「方法区地址保持一致」，「栈内存」指向「堆内存外部」。

   生成字符串的B方法中，会直接在「方法区的字符串常量区域」进行查找，如果没有「hello」存在，则新建，如果有则直接指向。

2. **字符串赋值特点**

   字符串赋值后的内容是无法变化的，但是「引用指向」是可以变化的

3. **字符串思考题**

   思考一：

   ```java
   String s1 = new String("hello");
   String s2 = new String("hello");
   System.out.println(s1 == s2);// false，比较地址值，地址值不同
   System.out.println(s1.equals(s2));// true，字符串的String类中的equals方法被重写过，比较内容
   
   String s3 = new String("hello");
   String s4 = "hello";
   System.out.println(s3 == s4);// false 
   System.out.println(s3.equals(s4));// true
   
   String s5 = "hello";
   String s6 = "hello";
   System.out.println(s5 == s6);// true
   System.out.println(s5.equals(s6));// true
   ```

   思考二：

   ```java
   String s1 = "hello";
   String s2 = "world";
   String s3 = "helloworld";
   System.out.println(s3 == s1 + s2);// false
   System.out.println(s3.equals((s1 + s2)));// true
   
   System.out.println(s3 == "hello" + "world");// false 这个我们错了，应该是true
   System.out.println(s3.equals("hello" + "world"));// true
   ```

   System.out.println(s3 == "hello" + "world");// false 这个我们错了，应该是true 

   为什么这样呢？

   如果是两个变量相加，如System.out.println(s3 == s1 + s2);

   那么JVM会先在方法区开辟空间，再相加。

   如果是两个常量相加，JVM会在其中寻找是否存在相加好的常量，如果存在，则返回，不需要再申请空间。

4. **字符串功能**

   （1）判断功能

   boolean equals(Object obj)：比较字符串内容，区分大小写

   boolean equalsIgnoreCase(String str)：比较字符串内容，不区分大小写

   boolean contains(String str)：比较字符串是否包含指定内容

   boolean startsWith(String str)：开头是否包含指定内容

   boolean endsWith(String str)：结尾是否以指定内容结尾

   boolean isEmpty()：字符串是否为空

   （2）获取功能

    int length()：获取字符串长度

   char charAt(int index)：获取指定位置的

   int indexOf(int ch)：获取字符串第一次出现的索引位置，但是字符为什么是int?因为'a'也可以被表示为97

   int indexOf(String str)：获取字符串第一次出现的索引位置

   int indexOf(int ch,int fromIndex)：获取在指定位置后出现的索引位置

   int indexOf(String str,int fromIndex)：获取在指定位置后出现的索引位置

   String substring(int start)：获取切割后的字符串

   String substring(int start,int end)：获取切割后的字符串内容，不包含右边索引
   （3）转换功能

   byte[] getBytes()：字符串转换为数字

   char[] toCharArray()：字符串转换为字符数组

   static String valueOf(char[] chs)：字符数组转换为字符数组

   static String valueOf(int i)：数字转换为字符

   String toLowerCase()：改为小写

   String toUpperCase()：改为大写

   String concat(String str)：拼接字符串
   （4）其他功能

   （4.1）替换功能 

   String replace(char old,char new)：替换字符串中出现的字符

   String replace(String old,String new)：替换字符串中出现的字符

   （4.2）去空格功能

   String trim()：去除字符串中开头与结尾的空格字符

   （4.3）按字典比较功能

   int compareTo(String str)：按照字母的顺序进行比较

   int compareToIgnoreCase(String str) ：忽略大小写的同时进行字母顺序的比较

   这里无非两种情况

   A:字符串的长度相同时

   ​	第一个相同位置出现的不同字母顺序进行比较

   B:字符串长度不同

   ​    第一个相同位置出现的不同字母顺序进行比较

   ​	如果都相同，则用前者字符串的长度减去后者字符串的长度

   ### 3-字符串应用案例

   （1）模拟用户登录：「LogIn.java」

   （2）字符串遍历：「GetCharTest.java」

   （3）统计字符串中大写，小写及数字字符的个数：「FindCharNumber.java」

   （4）把字符串的首字母转成大写，其他小写：「MaxTheFirstChar.java」

   （6）统计大串中小串出现的次数：「FindminString.java」