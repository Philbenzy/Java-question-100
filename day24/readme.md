## JavaDay24 多线程（2）

本节的主要知识点：

（1）JDK5之后对于线程的锁定方法；

（2）死锁问题；

（3）线程之间通信问题：生产者与消费者；

（4）线程组

（5）线程池

（6）多线程实现（三种）

（7）多线程面试

（8）设计模式

（9）Runtime

### 1-JDK5之后对于线程的锁定方法

（1）lock锁

lock锁相对于synchronized锁相比，可以更加明确的看到锁是如何上锁与解锁的

```java
// 锁对象的创建使用实体类ReentrantLock()创建，使用xx.lock() xx.unlock()上锁与解锁。

public class SellTicket implements Runnable {

   // 定义票
   private int tickets = 100;

   // 定义锁对象
   private Lock lock = new ReentrantLock();

   @Override
   public void run() {
      while (true) {
         try {
            // 加锁
            lock.lock();
            if (tickets > 0) {
               try {
                  Thread.sleep(100);
               } catch (InterruptedException e) {
                  e.printStackTrace();
               }
               System.out.println(Thread.currentThread().getName()
                     + "正在出售第" + (tickets--) + "张票");
            }
         } finally {
            // 释放锁
            lock.unlock();
         }
      }
   }
```

### 2-死锁问题

（1）死锁的出现

死锁可以由哲学家进餐呈现，两个或者两个以上线程在争夺资源的过程中，发生互相等待对方释放锁的现象。

（2）代码复现

```java
package my_work.test1;
// 死锁问题复现

public class MyDieLock extends Thread{
    private boolean flag;

    MyDieLock(boolean flag){
        this.flag = flag;
    }

    // 死锁代码
    @Override
    public void run() {
        if (flag){
            synchronized (MyLock.obj1){
                System.out.println("if obj1");
                synchronized (MyLock.obj2){
                    System.out.println("if obj2");
                }
            }
        }else {
            synchronized (MyLock.obj2){
                System.out.println("else obj2");
                synchronized (MyLock.obj1){
                    System.out.println("else obj1");
                }
            }
        }
    }
}

public class MyLock {
    public static final Object obj1 = new Object();
    public static final Object obj2 = new Object();
}

public class MyLockDemo {
    public static void main(String[] args) {
        MyDieLock dl1 = new MyDieLock(true);
        MyDieLock dl2 = new MyDieLock(false);

        dl1.start();
        dl2.start();
    }
}
```

结果：

if obj1
else obj2

程序进行等待状态

### 3-线程之间通信问题：生产者与消费者

（1）复现类说明

- 资源类：设定生产对象的标准，这里以MyStudent2为例；
- 设置数据类（生产者）：Set类中，我们交替改变设置MyStudent2的姓名与年龄；
- 获取数据类（消费者）：Get类中，我们获取设置好的值，让修改后的结果交替出现；
- 测试类：开启生产与消费多线程，控制台交替打印出设置好的值

（2）线程间如何通信？

Set与Get通过包含在MyStudent2类中的布尔标识符进行通信，当设置完成资料后，布尔标识符改变，Set线程等待，释放锁，Get线程就绪，得到执行权后，Get线程开始执行，获取资料后，Get线程改变布尔标识符，释放锁，之后，Set线程再进行工作。

整个过程中，MyStudent2类为公用的对象。

### 4-线程组

- 把多个线程进行组合，方便统一处理
- ThreadGroup(String name)创建一个新组
- Thread(ThreadGroup group, Runable target, String name)，将创建好的线程归纳为组
- 对于Thread类，可以使用GetThreadGroup类进行线程组类对象获取，再对线程组进行操作

### 5-线程池

（1）线程池

线程池中的每一个线程在执行完任务后，被JVM回收，再次回到线程池中成为空闲状态，等待下一个对象使用。

（2）线程池的创建

```java
// 创建线程池对象，指定需要控制的线程数量
public static ExecutorService newFixedThreadPool(int nThreads)

// 使用submit()方法开启多线程，只能执行实现Runable和Callable接口的线程;
(1)Runable:Future<?> submit(Runnable task)
(2)Callable:<T> Future<T> submit(Callable<T> task)
```

（3）Callable实现是带有返回值的，例如下面对多个数字求和案例

```java
import java.util.concurrent.Callable;

/*
 * 线程求和案例
 */
public class MyCallable implements Callable<Integer> {

   private int number;

   public MyCallable(int number) {
      this.number = number;
   }

   @Override
   public Integer call() throws Exception {
      int sum = 0;
      for (int x = 1; x <= number; x++) {
         sum += x;
      }
      return sum;
   }

}

public class CallableDemo {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// 创建线程池对象
		ExecutorService pool = Executors.newFixedThreadPool(2);

		// 可以执行Runnable对象或者Callable对象代表的线程
		Future<Integer> f1 = pool.submit(new MyCallable(100)); // 注意返回的对象
		Future<Integer> f2 = pool.submit(new MyCallable(200));

		// V get()
		Integer i1 = f1.get();
		Integer i2 = f2.get();

		System.out.println(i1);
		System.out.println(i2);

		// 结束
		pool.shutdown();
	}
}
```

### 6-多线程实现（三种）

（1）三种方法实现多线程

1. 继承Thread类实现

2. 实现Runnable接口

3. 使用线程池ExecutorService实现

```java
// （1）多线程类继承Thread后，重写run方法，启动方式为自定义Thread类执行start()方法；
public class MyThread extends Thread {  
　　public void run() {  
　　 System.out.println("MyThread.run()");  
　　}  
}  
 
MyThread myThread1 = new MyThread();  
MyThread myThread2 = new MyThread();  
myThread1.start();  
myThread2.start();  

// （2）实现Runnable接口，需要在类中重写run方法，主程序中先实例化一个Thread对象，在对象中传入自己的类，使用start开启；
MyThread myThread = new MyThread();  
Thread thread = new Thread(myThread);  
thread.start(); 

// （3）使用ExecutorService线程池开启多线程，与以上两个方法不同点在于，1不带返回值的多线程对象实现Runnable接口，2带返回值的多线程对象实现Callable接口，实现Runnable接口：
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int x = 0; x <= 100; x++) {
            System.out.println(Thread.currentThread().getName() + ":" + x);
        }
    }
}

ExecutorService pool = Executors.newFixedThreadPool(2);
pool.submit(new MyRunnable());
pool.submit(new MyRunnable());//获取线程

// 实现Callable带返回值：
public class MyCallable implements Callable {
    private int number;

    MyCallable(int number) {
        this.number = number;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= number; i++) {
            sum +=i;
        }

        return sum;
    }
}

        ExecutorService pool = Executors.newFixedThreadPool(2);

        Future<Integer> sum1 = pool.submit(new MyCallable(100));
        Future<Integer> sum2 = pool.submit(new MyCallable(200));

        Integer i1 = sum1.get();
        Integer i2 = sum2.get();
        System.out.println("sum1:"+i1);
        System.out.println("sum2:"+i2);

        pool.shutdown();
```

### 7-多线程面试

（1）多线程的实现方案

两种+线程池方式，如上；

（2）同步有几种方式

代码块同步与方法同步

（3）run与start区别

run方法中封装了需要执行的线程代码，如果直接调用run方法，与普通方法没有差别；使用start方法可以开启多线程。

（4）sleep与wait

sleep方法不释放锁，其他线程无法执行；wait方法在执行时释放锁，sleep方法为Thread的，wait方法为Object的方法，

（5）为什么wait(),notify(),notifyAll()等方法都定义在Object类中？

是因为锁对象，synchronized中需要一个锁对象，同时可以充当锁对象的为Object类对象。

### 8-设计模式

（1）设计模式分类

- 创建型
- 结构型
- 行为型

（2）设计模式小例子

工厂模式的作用是帮助调用者创建标准对象

- 简单工厂模式
- 工厂方法模式「案例演示：package.Factory」

Factory:工厂接口，定义需要实现的方法createAnimal()

CatFactory:造猫工厂，返回猫对象；

DogFactory:造狗工厂，返回狗对象；

Animal:动物抽象方法，定义需要实现的抽象方法eat；

Cat:实现抽象方法eat；

Dog:实现抽象方法eat;

FactoryDemo:使用抽象方法制造猫对象与狗对象，分别调用eat方法；

- 单例模式「package.hungryAndLazy」
  - 饿汉式「hungryDemo.java」
  - 懒汉式（延迟加载，有线程不安全隐患）「LazyDemo.java」

单例模式需要三部

- 私有构造方法
- 创建对象
- 提供访问方法

### 9-Runtime

Runtime类的内部是使用单例进行编写：

```java
private Runtime() {}

private static Runtime currentRuntime = new Runtime();

public static Runtime getRuntime() {
      	return currentRuntime;
}
```

Runtime类中的方法exec()，可以执行应用命令