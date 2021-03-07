## JavaDay27 反射

（1）反射

（2）设计模式

（3）JDK5、6、7新特性

### 1-反射

**（1）类的加载及类加载器**

当使用到某个类时，如果类还未记载进入没存，则需要通过

- 加载
- 连接
- 初始化

三步完成对类的加载

**（2）反射**

反射能够使用到的类中的

- 成员变量    Field
- 构造方法 Constructor
- 成员方法 Method

三者对应着两类不同的获取方式，含有Declared的获取与不含有Declared的获取，Declared能够获取所有的东西，不用担心权限修饰符，不含有Declared的获取不能忽视权限修饰符。

同时，

反射就是通过**类**加载进入内存的**class文件对象**，去使用类中的成员变量、成员方法、构造方法；

获取不同的类中的成员变量、成员方法、构造方法前，首先需要获取class类的对象，方法如下：

- 1 对于创建好的对象使用：getClass( )方法
- 2 使用数据类型的静态属性class获取
- 3 使用Class类中的静态方法：public static Class forName(String className)

反射能够使用的对象：

```java
//方法1 
Person p = new Person;
Class c1 = p.getClass();
//方法2
Class c2 = Person.class;
//方法3
Class c3 = Class.forName("包名.路径")
```

**（3）反射使用**

- 反射获取构造方法

```java
// (1)获取所有公共构造方法
	public Constructor[] getConstructors()
// (2)所有构造方法，包括私有，默认修饰符
    public Constructor[] getDeclaredConstructors()
// (3)获取公共的某个指定构造方法
    public Constructor<T> getConstructor(Class<?>... parameterTypes)
   // (3.1)使用带参构造方法对象创建对象
   		public T newInstance(Object... initargs)

        //例如：获取指定的构造方法后，新建对象
        Constructor con = c.getConstructor(String.class, int.class,String.class);
		Object obj = con.newInstance("林青霞", 27, "北京");
// (4)获取某一个指定的构造方法
	public Constructor<T> getDeclaredConstructor(Class<?>... parameterTypes)
        // 例如获取一个私有的：
        	Constructor con = c.getDeclaredConstructor(String.class);
			Object obj = con.newInstance("WZY");
			// 如果提示非法访问，使用setAccessible(true);设置访问权限为可以访问即可；
```

- 反射获取成员变量

反射获取成员变量，同样分为getConstructors、getDeclaredConstructors，获取公共的成员变量与所有成员变量

```java
// 获取对象
public class Person {
    private String name;
    int age;
    public String address;

    public Person() {
    }

    private Person(String name) {
        this.name = name;
    }

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public void show() {
        System.out.println("show");
    }

    public void method(String s) {
        System.out.println("method " + s);
    }

    public String getString(String s, int i) {
        return s + "---" + i;
    }

    private void function() {
        System.out.println("function");
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + ", address=" + address
                + "]";
    }

}
```

```java
public class Reflect {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {

        Class c = Class.forName("test1.Person");
		// (1) 获取私有的成员变量
        Field nameField = c.getDeclaredField("name");
        // (2) 设置访问权限
        nameField.setAccessible(true);
        // 使用set方法传入设置对对象与设置值
        nameField.set(obj,"WZY");
		// (3) 获取默认访问成员变量
        Field ageField = c.getDeclaredField("age");
        ageField.setAccessible(true);
        ageField.set(obj,25);
		// (4)获取公共成员变量
        Field addressField = c.getField("address");
        addressField.set(obj,"昆明");

        System.out.println(obj);
    }
}
```

- 反射获取成员方法
  - 通过指定方法名称获取
  - 通过指定方法传递参数获取

public Method getMethod(String name,Class<?>... parameterTypes)：方法的返回值为method方法

public Object invoke(Object obj,Object... args)

```java
public class ReflectDemo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class c = Class.forName("test1.Person");

        Constructor con = c.getDeclaredConstructor();

        Object obj = con.newInstance();
		// 方法1：获取方法show
        // 
        Method m = c.getDeclaredMethod("show");
		// 调用方法invoke，方法唤起对象
        m.invoke(obj);

        System.out.println("- - ");
		// 方法2：通过参数获取方法
        // public Method getMethod(String name,Class<?>... parameterTypes)
        Method m2 = c.getMethod("method", String.class);
        m2.invoke(obj,"nihao");
        
        System.out.println("- - ");
        
        Method m3 = c.getMethod("getString", String.class, int.class);
        Object o = m3.invoke(obj,"你好",003);
        System.out.println(o);
    }
}
```

**（4）反射案例**

- 使用反射配置文件内容

说明：

1需要配置者明确键值对；

2读取配置文件util；

3使用Properties加载配置文件；

4获取键的对应值；

5将值找到class文件

6找到创建实例的构造方法

7构造对象

8得到指定的方法

9方法唤起对象

案例演示：「package.method3」

- 反射越过泛型检测

泛型出现在编译阶段，将运行阶段可能出现的错误，提前到了编译阶段来保证代码的安全性，但是，通过反射的做法可以绕过泛型的编译约束，直接传值进入被泛型约束的集合。

```java
public class ArrayListDemo {
   public static void main(String[] args) throws NoSuchMethodException,
         SecurityException, IllegalAccessException,
         IllegalArgumentException, InvocationTargetException {
      // 创建集合对象
      ArrayList<Integer> array = new ArrayList<Integer>();

      // array.add("hello");
      array.add(10);

      Class c = array.getClass(); // 集合ArrayList的class文件对象
      Method m = c.getMethod("add", Object.class);

      m.invoke(array, "hello"); // 调用array的add方法，传入的值是hello
      m.invoke(array, "world");
      m.invoke(array, "java");

      System.out.println(array);
   }
}

```

案例演示：「package.test5」

- 反射给任意对象的任意属性赋值

也就是说，反射能够获取属性中的任意值，通过绕过访问筛查，访问私有成员变量，对Field对象进行set设置

**（5）动态代理**（P770）

代理：本来应该自己做的事情，却请了别人去做

动态代理：程序的运行过程中产生的某个对象。

运行过程中：表示的是，运行过程中产生的Class文件，其实就是通过反射生成的代理。

****

**（5.1）newProxyInstance创建代理对象说明**：

在Java中java.lang.reflect包下提供了一个Proxy类和一个InvocationHandler接口，通过使用这个类和接口就可以生成动态代理对象。

Proxy类中的方法创建动态代理类对象

具体如下：

- public static Object newProxyInstance(ClassLoader loader,Class<?>[] interfaces,InvocationHandler h)
  - 参数一：ClassLoader对象，定义了由哪个ClassLoader对象来对生成的代理对象进行加载
  - 参数二：Interface对象的数组，表示的是我将要给我需要代理的对象提供一组什么接口，如果我提供了一组接口给它，那么这个代理对象就宣称实现了该接口(多态)，这样我就能调用这组接口中的方法了
  - 参数三：InvocationHandler对象，表示的是当我这个动态代理对象在调用方法的时候，会关联到哪一个InvocationHandler对象上

**（5.2）InvocationHandler对象说明**

- InvocationHandler：在这个参数里面，定义着动态代理需要实现的方法
- 传入的InvocationHandler对象，需要实现InvocationHandler接口，重写invoke方法
- 方法具体是：Object invoke(Object proxy,Method method,Object[] args)
  - proxy:代表动态代理对象
  - method:代表正在执行的方法
  - args:代表调用目标方法时传入的实参
  - 返回对象为一个代理对象

动态代理做到了使用新建的对象，创建一个与运行对象类型相同，但是又有区别的对象，它可以完成一些其它事情。

**（5.3）最终动态代理调用方法流程：**

- 动态代理对象调用方法，会使用newProxyInstance中传入的InvocationHandler具体对象里的invoke方法
- invoke方法中，需要明确传入被代理的对象
- 方法invoke中，使用method.invoke(代理对象)调用原始方法
- 可以在原始方法前后加入代理需要完成的额外方法

**「案例演示：package.test5」**

### 2-设计模式（未完成）

（1）装饰器设计模式

（2）模板设计模式

案例演示：「package.test7」

### 3-JDK新特性（未完成）

（1）JDK 5

- 自动装箱与拆箱
- 泛型
- 增强for
- 静态导入
- 可变参数
- 枚举

（2）JDK 6

（3）JDK 7

- 二进制表示形式
- _分割数据
- switch分割数据
- 泛型推断
- 多catch使用
- try自动释放资源

（4）JDK 8