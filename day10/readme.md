# JavaDay10面向对象
## 1-形式参数和返回值问题
1. **形式参数**

   （1）基本类型：例如 int float，这个没什么好说的，函数将参数列表内的值带入函数内部进行计算

   （2）引用类型：这里的引用类型，有三类(a)对象类(b)接口类(c)抽象类，这三个不同类型统称为的引用类型可以在函数中充当形式参	   					  数，此时，这里出现的引用类型表示这里需要的东西为一个具体实例对象。

   ```java
   // 案例1：形参为对象类
   public class ClassDemo{
       public static void main(String[] args){
           Student s = new Student();
           StudentTool st = new StudentTool();
           st.tool(s); // 形参Student做为对象类进行传递
       }
   }
   
   class Student{
       public void study(){
           System.out.println("我爱学习Java");
       }
   }
   
   class StudentTool{
       public void tool(Student s){ // 形参Student做为对象类进行传递
           s.study();
       }
   }
   ```

   ```java
   // 案例2：形参为抽象类
   // 另一个案例：absTractDemo.java
   public class abstractDemo{
       public static void main(String[] args){
           LearningMath lm = new Student();//多态创建对象
           LearningTool lt = new LearningTool();
           lt.tool(lm)
       }
   }
   
   abstract class LearningMath{
       public abstract void study();
   }
   
   class Student extends LearningMath(){
       public void study(){
           System.out.println("学习数学！")
       }
   }
   
   class LearningTool{
       public void tool(LearningMath lm){// 抽象类作为参数进行传递
           lm.study();
       }
   }
   ```

   ```java
   // 案例3：形式参为接口
   // 另一个案例：InterFaceDemo.java
   
   public class InterFaceDemo {
       public static void main(String[] args) {
           Person3 p = new Person3();// 创建接口子类的具体对象
           SmokingTool st = new SmokingTool();
           st.method(p);
       }
   }
   
   interface Smoke{
       public abstract void smoking();
   }
   
   class Person3 implements Smoke{
       public void smoking(){
           System.out.println("学习抽烟...");
       }
   }
   
   class SmokingTool{
       public void method(Smoke s){  //形式参为接口
           s.smoking();
       }
   ```

   

2. **返回值类型**
   ​		基本类型：例如int float，也没什么好说的
   ​		引用类型：关于引用类型作为返回值，也可以是三种(a)类(b)抽象类(c)接口，它们返回的也都是三种的具体实现对象

   ```java
   // 案例1：返回值是类
   // 另一个案例：AbstractDemo2.java 
   class StudentDemo{
       public static void main(String[] args){
           MakeStudent ms = new MakeStudent();
           Student s = ms.getStudent();// 方法的返回值是类
           s.method();
       }
   }
   
   class Student{
       public void method(){
           System.out.println("学习Java");
       }
   }
   
   class MakeStudent{
       public Student getStudent(){
           return new Student();// 方法的返回值是类
       }
       
   }
   ```

   ```java
   // 案例2：方法的返回值是一个抽象类
   class AbstractDemo{
       public static void main(String[] args){
           MakePerson mp = new MakePerson();
           Person p = mp.getPerson(); // 多态
           p.study();
       }
   }
   
   
   abstract class Person{
       public abstract void study();
   }
   
   class Student extends Person{
       public void study(){
           System.out.println("王大锤学习Java")
       }
   }
   
   class MakePerson(){
       public Person getPerson(){
           // Person p = new Student();
           // return p;
           return new Student();// 返回抽象类的具体实现类
       }
   }
   ```

   ```java
   // 案例3：方法的返回值是一个接口类
   class InterfaceDemo{
   	public static void main(String[] args){
   		MakeTeacher mt = new MakeTeacher();
           Love l = mt.getTeacher();
           l.love();
   	} 
   }
   
   interface Love{
       public abstract love();
   }
   
   class Teacher implements love{
       public void love(){
           System.out.println("老师爱学生，学生爱Java!")
       }
   }
   
   class MakeTearcher{
       public Love getTeacher{
           //Love l = new Teacher();
           //return l
           
           return new Teacher();
       }
   }
   ```



**链式编程**：当调用的方法返回的是一个实例对象的时候，这时候我们有两种选择

（1）找一个对象名称，用来接收它

（2）采用链式编程的格式调用这个对象内的方法



案例演示：AbstractDemo2.java 

## 2-包的定义及注意事项

1. 包的本质就是文件夹
2. 包可以通过功能来划分、包可以通过模块区分
3. 包使用 「package 包名」定义，多级包使用「包名.子包」划分
4. 带包的编译命令「javac -d xxxx.java」

注意事项

1. 定义包的语句出现在java文件可执行的第一句
2. 一个java内只能定义在一个内包

## 3-导包及注意事项

1. 导入一个包使用「import」关键字，「import 包名.类名」,不建议使用*全部导入
2. import class package 关键字是有执行顺序的：package > import > class

## 4-四种权限修饰符及其特点

|           | 本类 | 同一个包下 | 不同包下子类 | 不同包无关类 |
| :-------: | :--: | :--------: | :----------: | :----------: |
|  private  |  Y   |            |              |              |
|   默认    |  Y   |     Y      |              |              |
| protected |  Y   |     Y      |      Y       |              |
|  public   |  Y   |     Y      |      Y       |      Y       |

常见的java修饰符可以被分为三类：

（1）权限修饰符：public、private、 默认、protected

（2）状态修饰符：final、static

（3）抽象修饰符：abstract

这些修饰符修饰的对象可以分为四种：

（1）可修饰**类**：public final abstract 默认

（2）可修饰**成员变量**:private 默认 final private static protectde

（3）可修饰**成员方法**:public final 默认 static protected abstract 

（4）可修饰**构造方法**:private 默认 protected public 

## 5-常见的修饰符及组合

- public static final int x = 10;
- public static void show( ) { }
- public final void show( ) { }
- public abstract void show( );

## 6-内部类的概述及访问特点

特点：

1. 内部类与外部类之间没有继承关系，内部类可以直接访问外部类的成员，不管外部类是否有private声明；
2. 外部类想要访问内部类的成员时，需要创建对象访问，创建内部类格式「外部类名.内部类名  对象名称 =  new 外部名称.new 内部类名()」；
3. 成员内部类是静态类时，则访问内部类的方式为：「外部类名.内部类名  对象名称 =  new 外部名称.内部类名()」；

```java
(5)成员内部类的面试题(填空)
		30,20,10
		
		class Outer {
			public int num = 10;
			
			class Inner {
				public int num = 20;
				
				public viod show() {
					int num  = 30;
					
					System.out.println(A1);
					System.out.println(A2);
					System.out.println(A3);
				}
			}
		}
//问：如果向让控制台输依次出30 20 10 请问应该怎么填写？ 
A1:num
A2:this.num
A3:Outer.this.num
```

案例演示：HeartDemo.java

## 7-内部类的分类

内部类可以定义为两种类型：

- 成员内部类（直接定义在一个类的代码块内）
- 局部内部类（定义在一个方法中的类）

局部内部类在Java8之前都必须使用final关键字进行修饰，原因如下：

因为局部内部类是定义在方法当中的，我们知道，当方法执行完毕时，方法内的成员变量从内存消失，方法也随即消失，这时候问题出现了，局部内部类却不会消失，基于此，如果这个类继续访问这个方法中的成员变量，就会面临访问的对象消失不见的情况，所以这时，方法局部成员就会被final关键字默认修饰（Java8之后）

## 8-匿名内部类的格式和应用及面试题

匿名内部类可以是

- 抽象类
- 接口

虽然在定义的时候是这样进行定义的，但还需要知道的是，这里其实是抽象类的子类或者接口的具体实现，如果需要调用一次调试，那么就可以把它写成一个匿名内部类。

案例演示：

```java
interface Inter{
    void show();
}

class Outer{
    public static Inter method(){
        return new Inter(){
            public void show(){
                System.out.println("匿名内部类的应用")
            }
        }
    }
}

class InterDemo{
    Outer o = new Outer();
    o.metohd().show()//静态方法可以直接通过类名进行访问
}
```

案例演示：

```java
interface Person{
    void show();
}

class PersonDemo{
    public void method(Person p){
        p.show();
    }
}

class PersonTest{
    public static void main(String[] args)
        PersonDemo pd = new PersonDemo();
    	pd.show(new Person(){
            public void show(){
                System.out.println("匿名方法的调用！")
            }
        });
}
```

