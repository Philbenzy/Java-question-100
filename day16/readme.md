## JavaDay16集合框架

### 1-List的子类特点

（1）ArrayList

底层为数组结构，增删慢，查询快，线程不安全，执行效率高

（2）Vector

和ArrayLsit一样，但是线程安全，执行效率低

（3）LinkedList

底层为链表结构，查询慢，增删快，线程不安全，执行效率高

### 2-ArrayList练习

两个小练习：

   A:ArrayList存储字符串并遍历

   B:ArrayList存储自定义对象并遍历

### 3-LinkedList练习
（1）LinkedList存储字符串并遍历「StorageUseCollection.java」

（2）LinkedList存储自定义对象并遍历「StorageUseCollection.java」

### 4-泛型是什么?格式是?好处是?

（1）泛型是什么？

- 早前在Java中使用Object类型作为集合中的元素类型，当需要使用这个集合时，我们就需要使用到类型转换，可以随便转换吗？例如从Integer向String进行转换，当然不能了，所以，我们就需要约定一个新的东西，帮助规范从集合中取出来的元素，泛型这一概念，就来了。
- 所以，泛型的作用在于推迟类型的确定，让明确类型的工作再创建对象、调用方法时再确定，泛型做到了将数据类型当作一个参数进行传递。

（2）泛型的格式

<数据类型>

此处的数据类型只能是引用类型

（3）泛型优点

- 避免了每次都进行的类型强转（迭代器的next方法返回的时一个Objec类型）
- 把运行时期出现的问题提前到了编译时期
- 可以视数据类型为一个参数，进而传递

（4）泛型的位置

- 泛型出现在类名上

```java
public class MyStudent<T> {
    private T obj;

    public void setObj(T obj){
        this.obj = obj;
    }

    public T getObj(){
        return obj;
    }
}
```

- 泛型出现在方法上

```java
public class MyPerson {
    public <T> void show(T t) {
        System.out.println(t);
    }
}
```

- 泛型出现在接口上

泛型出现在接口上时，这里有两种情况

- 
  - 实现类**知道**我需要实现的类型是什么
  - 实现类**不知道**我需要实现什么类型，需要到调用再明确

例如：

```java
// 接口
public interface Inter<T> {
    public abstract void show(T t);
}
```

```java
// 实现类知道我需要实现的类型是什么
public class InterImp implements Inter<String> {
    public void show(String s){
        System.out.println(s);
}
```

```java
// 实现类不知道我需要实现什么类，需要到调用再明确
public class InterImp<T> implements Inter<T> {
    public void show(T t) {
        System.out.println(t);
    }
}
```



### 5-增强for的格式是?好处是?弊端是?

（1）增强for的格式

```java
for(数据类型 引用名称 : 数组或者Collection集合){
	//使用引用的名称即可
}
```

增强for的底层仍然使用到的是创建迭代器，所以，仍然有可能会出现空指针异常的情况。

（2）好处

- 可以不用创建迭代器的创建
- 简化了遍历的流程书写

（3）弊端

需要在前方对数组或者集合进行非空判断

### 6-静态导入的格式是?注意事项是?

静态导入可以避免方法前缀的书写，导入到方法级别。

（1）静态导入的格式

格式：import static 包名….类名.方法名;

（2）注意事项

- 只能导入静态方法
- 多个同名静态方法不能这样操作

### 7-可变参数的作用是?格式是?注意事项是?

可变参数：在定义方法的时候允许传入的参数列表中的个数未知

（1）格式

```
修饰符 返回值类型 方法名(数据类型… 变量名){

}
```

（2）注意

如果一个方法有可变参数的话，并且有多个参数，那么可变参数一定是最后一个出现。



### 8-完成八个代码练习

（1）Collection、List、ArrayList、Vector、LinkedList存储字符串并遍历，   加入泛型，并有增强for遍历。

 案例演示：「StorageUseCollection.java」

（2）泛型定义在类、方法、接口上

案例演示：

- 类：package 「my_work.genericWithClass」

- 方法：package 「my_work.genericWithMethod」

- 接口：package「my_work.genericWithInter」

（3）集合的嵌套遍历

案例演示「ArrayListLoop.java」

（4）产生10个1-20之间的随机数，要求随机数不能重复

案例演示：「RandomTenDemo.java」

（5）键盘录入多个数据，以0结束，并在控制台输出最大值

案例演示：「RandomFromKeyboard.java」

（6）去除集合中的多个字符串的重复元素（创建了新的数组）

案例演示：「ArrayListGetOutDupil.java」

（7）去除集合中的多个自定义对象的重复元素（不创建新数组）

案例演示：「ArrayListWithNoNew.java」

（8）用LinkedList模拟一个栈数据结构的集合类，并测试。

案例演示：「LinkedListDemo.java」



