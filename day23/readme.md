## JavaDay23 多线程（1）

### 1-多线程概述

（1）线程与进程

进程：系统中运行的应用程序；

线程：应用程序为了提高自身的执行效率，是进程执行的单元，多线程有助于提高程序使用率；

进程与线程之间，举个例子帮助理解，就像是手掌上的5根指头，在打字、拿东西时提高了我们的执行效率

### 2-Java程序的运行原理 & JVM的启动

运行原理：使用Java命令开启JVM，之后JVM启动进程，进程又会启动一个主线程；

JVM启动：最低启动了两个线程，主线程与垃圾回收线程

### 3-多线程的实现方案

- 继承方式：继承Thread类
  - 自定义类继承Thread
  - 重写run方法
  - 创建MyThread类对象
  - 启动线程对象
- 接口方式：实现Runable接口
  - 自定义类实现接口Runable
  - 重写run方法
  - 创建自定义类对象
  - 创建Thread对象，传入第三步创建的对象

二者都需要重写run()方法，在主线程中使用start()方法启动；

**问题：**run()与start()方法的区别

如果只调用了run方法，那么与普通执行没有区别，start方法会开启多线程

代码实现：

```java
// 方式一：继承Thread类
public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("方法开始执行！");
        for (int x = 0; x < 10; x++) {
            System.out.println(getName()+" x:" + x);
        }
        System.out.println("方法执行完毕");
    }
}

public class MyThreadDemo {
    public static void main(String[] args) {
        MyThread mt1 = new MyThread();
        MyThread mt2 = new MyThread();

        mt1.start();
        mt2.start();
    }
}
```

```java
// 方式2：实现Runable接口
public class MyRunnable implements Runnable {

   @Override
   public void run() {
      for (int x = 0; x < 100; x++) {
         System.out.println(Thread.currentThread().getName() + ":" + x);
      }
   }
}

public class MyRunnableDemo {
	public static void main(String[] args) {
		MyRunnable my = new MyRunnable();

		// Thread(Runnable target, String name)
		Thread t1 = new Thread(my, "进程1");
		Thread t2 = new Thread(my, "进程2");

		t1.start();
		t2.start();
	}
}
```



### 4-线程调度 & 优先级

Java执行抢占制线程调度

优先级方面，使用setPriority(int a)设置优先级

JVM默认a=5，MAX =10，min=1;

### 5-线程控制

- 线程守护 public final void setDaemon(boolean on)

线程是否守护的意义在于，如果当前所执行的所有线程都属于守护线程，则线程退出；

- 线程加入 public final void join():等待该线程终止。 

在该线程终止后，其他线程才开始执行

- 线程睡眠 public static void sleep(long millis)

使用sleep方法使线程睡眠，线程进入阻塞状态

- 线程礼让public static void yield()

在run方法内写入该礼让方法，表示暂停当前正在执行的线程对象，执行其他线程，让多个线程执行更加和谐

### 6-线程生命周期

生命周期的组成被分为：创建、就绪、运行、阻塞、死亡

- 创建：使用strat()方法创建线程；
- 就绪：被创建的线程具有执行资格，但没有执行权；
- 运行：具有执行资格的线程，如果抢到了CPU执行权，则开始运行，**就绪**与运行可以直接进行转换；
- 阻塞：正在运行的线程使用sleep、wait方法被阻塞，被阻塞的方法唤醒后进入就绪状态；
- 死亡：重写的run()方法执行完毕，线程死亡，等待被回收

### 7-案例演示：「买票案例」

（1）案例

```java
public class SealTicket implements Runnable{
    private int ticket = 100;
    private Object obj = new Object();
    
    @Override
    public void run() {
        while (true) {
            synchronized (obj) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ": 正在出售第 " + ticket + " 张票...");
                    ticket--;
                } else {
                    System.out.println("Sale Out");
                    System.exit(0);
                }
            }
        }
    }
}

public class SynDemo {
    public static void main(String[] args) {
        SealTicket st= new SealTicket();

        Thread t1 = new Thread(st,"window1");
        Thread t2 = new Thread(st,"window2");
        Thread t3 = new Thread(st,"window3");
        Thread t4 = new Thread(st,"window4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
```

（2）问题

以上的案例不会出现卖负票，同票多次的问题，是因为需要执行的代码使用了synchronized关键字修饰；

那么之前的问题该怎么解释？

我们假设第一个线程准备对余票数量进行修改，此时另一线程读到了还未修改的余票数量，可能会出现票数的重复与负数。

### 8-多线程安全问题（判断是否存在安全问题）

（1）是否有多线程环节

（2）是否有共享数据

（3）是否有多条语句操作共享数据

### 9-同步解决线程安全问题

锁：synchronized（Object obj）{代码块}，其中，所的创建的锁对象，锁内需要一个对象保证多个线程使用一个共同的锁对象；

- 同步代码块

使用synchronized关键字修饰需要同步的代码

- 同步方法

在方法上声明关键词synchronized，此时锁对象为this

- （静态）同步方法

使用唯一的class文件创建锁对象,synchronized(xxx.class)

### 10-目前接触的线程安全类

目前，线程安全的类有三个

- StringBuffer sb = new StringBuffer();
- Vector\<String> vec = new Vector<>();
- Hashtable\<String, String> ht = new Hashtable<>(); 与hashMap类似，但是Hashtable为线程安全

注意：Vector一般不会使用，一般使用「public static \<T> List\<T> synchronizedList(List\<T> list)」可以创建线程安全的集合，例如：

List\<String> list = Collections.synchronizedList(new ArrayList\<String>());

### 11-案例

1. MyStop.java与MyStopDemo.java：interrupt()唤醒进程
2. SynDemo.java与SealTicket.java：锁机制同步卖票
3. MyStopDemo.java与MyStop.java：setPriority()方法设定优先级
4. MyThreadJoin.java与MyThread.java：join()方法有优先执行



