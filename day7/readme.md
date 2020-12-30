# Day7思考

## 1:局部变量和成员变量的区别?

(a) 定义的位置不同

​	局部变量：在类的方法中出现

​	成员变量：在所有类的方法外出现

(b) 所属不同

​	局部变量：属于这个类中的某个方法，出现在栈内存

​	成员变量：属于这个类自身，出现在堆内存

(c) 共享不同

​	局部变量：仅对某个具体的类内方法有效

​	成员变量：所有的对象都可以进行访问

(d)生命周期不同

​	局部变量：当方法执行完毕后被回收

​	成员变量：随着对象的创建而创建出来

(e)初始化值不同

​	局部变量：没有初始化值，需要对方法进行赋值才能使用

​	成员变量：有初始化值，int 为 0，String 为 null，boolena为 false



## 2:形式参数分别为基本类型和引用类型的问题?

基本类型：基本类型数据就是不需要new出来的类型

引用类型：引用类型包括类、对象、接口、数组等，需要new出来的



如下代码块

```java
class Student{
    public void method(){
        System.out,println("我爱学习Java")
    }
}

class Teacher{
    public void method(Student s){
        s.method	//在Teacher类型中，使用引用类型调用Student类;
    }
}

class StudentDemo{
    public static void main(String[] args){
        Student s = new Student();
        
        Teacher t = new Teacher(s);	//传入引用类型参数
        t.method();
    }
}
```



## 3:匿名对象是什么?应用场景是什么?

代码示例：MyNoName.java

匿名对象不需要指定对象的名称，适用于只调用一次该类对象的方法，调用完成后，就被垃圾回收。



## 4:封装是什么?Java中封装的体现有哪些?请举例说明。

（a）可以隐藏实现的细节

（b）提高代码的复用性

（c）Java中体现出的复用有使用private关键字，修饰类、成员变量、方法。

## 5:this关键字是什么?this关键字的应用场景?

我们知道，局部变量是可以与成员变量命名成相同的，但是还有一个注意事项，在方法中使用时，采用就近原则。所以，当向成员变量赋值时，为了防止在参数传入时因为就近原则互相覆盖，提出this关键字



**使用「this.成员变量」的方式**



解决局部变量隐藏成员变量的情况。



## 6:构造方法的作用是什么?构造方法的特点是什么?构造方法的注意事项是什么?构造方法中可不可以写return语句呢?

构造方法用来对对象初始化赋值，构造方法的特点在于:

(a) 必要可以自己写，也可以使用类中默认的构造方法，但是一旦自己写，默认方法自动消失

(b) 构造方法没有具体的返回值，所以没有void关键字

(c) 构造方法的命名与类对象名称相同

(d) 构造方法之间也可以重载



构造方法中虽然没有return语句，但是也可以写，因为「return;」标志着一个方法的结束

## 7:给成员变量赋值有几种方式?

(a) 使用构造函数赋值

(b) 使用函数内部的方法setXxx()

## 8:标准的代码编写及测试：
   A:学生类的案例：MyStudentTest.java
   B:手机类的案例：MyPhoneDemo.java
   C:长方形类的案例：CangFangXingDemo.java

## 9:一个类的成员变量初始化过程解释   Student s = new Student();

代码块：

```java
class Student {
			private String name;
			private int age;
			
			public Student(){}
			
			public Student(String name,int age) {
				this.name = name;
				this.age = age;
			}
			
			public String getName() {
				return name;
			}
			
			public void setName(String name) {
				this.name = name;
			}
			
			public int getAge() {
				return age;
			}
			
			public void setAge(int age) {
				this.age = age;
			}
		}
		
		测试：
		class StudentDemo {
			public static void main(String[] args) {
				Student s2 = new Student("刘意",30);
				System.out.println(s2.getName()+"---"+s2.getAge());
			}
		}
```

(1) 将class文件加载加载到内存

(2) 在栈内存中为s变量开辟空间

(3) 在堆内存中加载Student类

(4) 默认初始化Student的成员变量 name age

(5) 显示初始化Student的成员变量name = "刘意" age = 30

(6) 成员构造完毕，将堆内存中的地址赋值给栈中的s



## 10:static关键字是什么?有什么特点?什么时候用呢?

静态关键字，用来修饰成员变量与方法，特点在于：

(1) 随着类加载而加载

(2) 可以通过类名调用，无需创建对象

(3) 优先于对象而存在

(4) 被staitc修饰的关键字，被所有对象共享

(5) 静态方法与静态变量存储在方法区中

(5) 静态变量与成员变量相比较，具有不同的生命周期

## 11:main方法各种修饰符及参数的解释? public static void main(String[ ] args) 的解释

 public : 权限修饰符，给jvm足够大的权限

static: 静态修饰符，以前说明过，静态方法可以通过「类名.静态方法」进行调用；

void：不需要返回给JVM什么东西，没有意义

main：JVM识别的入口

(String[ ] args) : 早期Java没有Scanner对象，所以使用「java 主程序名称 xxxx」这样的方式录入字符串，现在就不需要了

