## JavaDay14常见类对象

### 1-正则表达式

（1）正则表达式常见规则模块

- 特殊的字符

x 字符 x。举例：'a'表示字符a

\\ 反斜线字符。

\n 新行（换行）符 ('\u000A') 

\r 回车符 ('\u000D')

- 字符类

[abc] a、b 或 c（表示方括号内的字符只出现一次） 

[^abc] 任何字符，除了 a、b 或 c（否定） 

[a-zA-Z] a到 z 或 A到 Z，两头的字母包括在内（范围） 

[0-9] 0到9的字符都包括

- 预定义字符

任何字符的本身表示方法：「\\.」表示

\d 数字：[0-9]

\w 单词字符：[a-zA-Z_0-9]

- 边界匹配

^ 行的开头 

$ 行的结尾 

\b 单词边界（表示）

- 数量词

（2）常见功能：

- 判断：String类的public boolean matches(String regex)
- 分割：String类的分割方法split()
- 替换：String类的public String replaceAll(String regex,String replacement)
- 获取：模式对象与匹配器对象

（4）模式对象与匹配对象

- 规则对象Pattern

模式对象的出现，就是把regex规则变成了一个可以使用的对象，之后，与Matcher结合使用

- 匹配对象Matcher

匹配对象的出现，是为了方便数据传入，一般做法：规则对象引用名称.matcher(匹配字段);

匹配对象的方法：find()，判断是否符合规则， group()返回匹配到的值。

```java
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 获取功能
 *    Pattern和Matcher类的使用
 *    
 *    模式和匹配器的基本使用顺序
 */
public class RegexDemo {
   public static void main(String[] args) {
      // 模式和匹配器的典型调用顺序
      // 把正则表达式编译成模式对象
      Pattern p = Pattern.compile("a*b");
      // 通过模式对象得到匹配器对象，这个时候需要的是被匹配的字符串
      Matcher m = p.matcher("aaaaab");
      // 调用匹配器对象的功能
      boolean b = m.matches();
      System.out.println(b);
      
      //这个是判断功能，但是如果做判断，这样做就有点麻烦了，我们直接用字符串的方法做
      String s = "aaaaab";
      String regex = "a*b";
      boolean bb = s.matches(regex);
      System.out.println(bb);
   }
}
```

（5）案例演示：

- 判断电话号码：「CheckPhone.java」
- 搜索好友年龄匹配（分割数据）：「splitDemo.java」
- 修改字符串数字为*（脏话屏蔽器）：「ReplaceWithStarts.java」
- 获取字符串中3个字符串组成的单词：「GetThreeDemo.java」

### 2-Math类

（1）Math类常见方法

- 绝对值public static **int** abs(int a)
- 向上取整public static **double** ceil(double a)
- 向下取整public static **double** floor(double a)
- 两个数据中的最大值public static **int** max(int a,int b)
- a的b次幂public static **double** pow(double a,double b)
- 随机数模块public static **double** random()
- 四舍五入public static **int** round(float a) 
- 正平方根public static **double** sqrt(double a)

### 3-Random类

（1）Random类的构造方法

- 无参构造Random()，默认以毫秒值作为种子初始化
- 带参构造Random(long seed)，指定种子，种子相同，随机数相同

（2）Random类的成员方法

- int nextInt()：返回int范围内随机数
- int nextInt(int n)：返回[0,n)范围内的随机数

### 4-System类

（1）常见的成员方法有

- 垃圾回收器public static void gc()
- 退出JVMpublic static void exit(int status)；int status表示退出时返回的值
- 获取当前的毫秒值public static long currentTimeMillis()
- 数组复制public static void arraycopy(Object src,int srcPos,Object dest,int destPos,int length)

注意：

- 垃圾回收器的主动g启动会让JVM尽所有能力回收使用过的对象，一般尽量少调用
- 终止程序的另一种方法：System.exit(0);
- 获取当前毫秒值一般start - end，得到程序运行的时间;

### 5- BigInteger类

（1）出现的原因：解决在int范围外出现的数字（-2147483648~2147483647）

（2）构造方法：BigInteger(String val) 只有一种带参方法

（3）成员方法

- 加、减、乘、除、商、余数，这些方法返回的值依旧是BigInteger和BigInteger[]

### 6-BigDecimal类

（1）出现的原因

```java
public class BigDecimalDemo {
   public static void main(String[] args) {
      System.out.println(0.09 + 0.01);//0.09999999999999999
      System.out.println(1.0 - 0.32);//0.6799999999999999
      System.out.println(1.015 * 100);//101.49999999999999
      System.out.println(1.301 / 100);//0.013009999999999999

      System.out.println(1.0 - 0.12);//0.88
   }
}
```

**为什么前四个的计算那么离谱？**

因为前面四个数字都是float类型的数字，小数存储方式与整数并不相同，小数带有有效数字位，而在计算时，容易将小数的精度丢失

（2）构造方法

public BigDecimal(String val)

（3）成员方法

- 加、减、乘、除、保留几位小数

与BigInteger相似，返回的还是BigDecimal类型的数字

### 7-Date/DateFormat类

（1）构造方法：

无参构造：Date():根据当前的默认毫秒值创建对象，与System.currentTimeMillis()类似；

带参构造：Date(long date)：根据给定的毫秒值创建日期对象，在基准时间「1970年1月1日」的基础上添加；

（2）成员方法

- getTime()：从Date得到一个毫秒值
- setTime()：把一个毫秒值转换为Date，从基准时间1970.1.1开始计算

（3）日期值与毫秒值的互换

使用除法将毫秒转换为小时即可，再传入Date

（4）DateFormate类与子类SimpleDateFormate

解释1：使用DateFormate类进行日期和字符串的格式化和解析；

解释2：DateFormate类是一个抽象类，不可被实例化，如果想要使用它，则需要使用它的实例化对象SimpleDateFormate；

- SimpleDateFormate的给定模式

  - 无参构造SimpleDateFormat()
  - 给定格式SimpleDateFormat(String pattren)

  模式的书写规则：

  |  年  |  y   |
  | :--: | :--: |
  |  月  |  M   |
  |  日  |  d   |
  |  时  |  H   |
  |  分  |  m   |
  |  秒  |  s   |

- **日期和字符串的转换方法**

  - **Date To String**：public final String **format**(Date date)
  - **String To Date**：public Date **parse**(String source)

### 8-Calendar类

（1）日历类介绍：日历类中可以向调用者提供指定的日期信息内容，如YEAR、MONTH、DAY_OF_MONTH、HOUR等，

（2）日历对象的创建方法

日历可以使用Calendar cal = Calendar.getInstance();进行创建，需要注意的是，这个创建并没有使用到new方法，所以说明，创建是使用**多态**完成的，在Calednar方法中存在静态方法，这个静态方法返回的是一个对象；

（3）日历对象的成员方法

- public int get(int field) 	返回日历的给定值
- public void add(int field,int amount) 根据当前日历，以当前日历为起始，指定修改内容
- public final void set(int year,int month,int date)：由用户指定设置当前日历

（4）案例演示：计算任意一年2月份有多少天「CalendarTwoMouth.java」



