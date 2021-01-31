## JavaDay15集合框架

本节学习到的内容有以下5类，不分先后顺序：

- 集合Collection体系结构
- List子类
- 与集合结合使用的迭代器对象
- 集合与数组的区别？
- 常见的一般数据结构整理

### 1-集合的由来?

- Collection
  - List
    - ArrayList
    - Vector
    - LinkedList
  - Set
    - hashSet
    - treeSet



在集合没有出现之前，使用**对象数组**来存储对象，但是，对象数组的长度一旦确定，则不可以发生变化，所以我们希望存在一个容器就像StringBuffer一样存储字符串，同时依据传入的值的个数不同，可以自动改变自身的长度，有这样的东西吗？有的，Collection就出现了，总结一下它的特点：

- 是一个长度可变的容器
- 用来存储对象

### 2-集合和数组的区别?

（1）长度区别

集合的长度可以变化，数组无法变化

（2）内容不同

- 数组中可以存储的是基本类型与引用类型，两种
- 集合中可以存储的只能是引用类型

（3）存储元素类别的区别

- 数组只可以存储相同类型的数据
- 集合中可以存储不同类型的引用对象

### 3-Collection集合的功能概述?

集合一般使用到的功能有：

* boolean addAll(Collection c):添加一个集合的元素
* boolean removeAll(Collection c):移除一个集合的元素(注意：**所有**)，只要有一个元素被移除，则返回true
* boolean containsAll(Collection c)：判断集合中是否包含指定的集合元素(注意：**所有**)
* boolean retainAll(Collection c):两个集合都有的元素?思考元素去哪了，返回的boolean又是什么意思呢?

retainAll方法中，是再求A、B个集合的交集，返回的boolean类型值说明，前面的A集合是否发生过变化。

### 4-Collection集合存储字符串并遍历?(迭代器)

在集合中存储字符串后，遍历可以通过两种方式实现：

- 与集合配套的迭代器实现
- Collection转化为String[ ]

这里我们先使用迭代器遍历集合，如下:

```java
package my_work;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IteratorAndString {
    public static void main(String[] args) {
        Collection col = new ArrayList();

        col.add("Hello");
        col.add("World");
        col.add("Java");

        Iterator it = col.iterator();
        while (it.hasNext()){
            String s = (String)it.next();// 疑问
            System.out.println(s);
            //System.out.println(it.next());注意：使用的这个方法是不安全的
        }
    }
}
```

**这里为什么在取出元素之后需要强制转型为String类型？难道我不知道我存储的是什么吗？**

回答：因为默认的迭代器中返回的元素类型默认是Object类的，为了避免之后的报错，最好将它强制转换，这个可以从原码中得到答案：

```java
public Object next(){} //迭代器中next()方法返回的是一个next对象。
```

### 5-Collection集合存储自定义对象并遍历?(迭代器)

（1）案例演示：「IteratorDemo.java」

案例中使用到的迭代器成员方法：

- boolena hasNext( )：判断迭代器中是否存在元素？
- Object next( )：以Object类型返回这个元素

使用这两个功能，就可以完成迭代器从集合中遍历元素。

（2）将Collection转换为数组后，使用For循环的遍历

```java
package my_work;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionToArray {
    public static void main(String[] args) {
        Collection c = new ArrayList();
        c.add("Hello");
        c.add("World");
        c.add("Java");

        Object[] objArray = c.toArray();
        for (int x= 0;x<objArray.length;x++){
            String s = (String)objArray[x];
            System.out.println(s);
        }
    }
}
```

### 6-List集合的特有功能?

```
* A:添加功能
*     void add(int index,Object element):在指定位置添加元素
* B:获取功能
*     Object get(int index):获取指定位置的元素
* C:列表迭代器
*     ListIterator listIterator()：List集合特有的迭代器
* D:删除功能
*     Object remove(int index)：根据索引删除元素,返回被删除的元素
* E:修改功能
*     Object set(int index,Object element):根据索引修改元素，返回被修饰的元素
*/
```

### 7-List集合存储字符串并遍历?(迭代器和普通for)

List集合**特有**的遍历，使用到size()方法和get()方法

```java
package my_work;
/**
 * 使用list中的size()方法与get()方法遍历列表*/
import java.util.ArrayList;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        List list = new ArrayList();

        list.add("Hello");
        list.add("Java");
        list.add("World");

        for (int x=0;x<list.size();x++){
            //System.out.println(list.get(x));

            // 推荐做法
            String s = (String)list.get(x);
            System.out.println(s);
        }
    }
}
```

```java
package my_work;

import java.util.ArrayList;
import java.util.List;

public class ListAndFor {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("hello");
        list.add("world");
        list.add("java");


        for (int x = 0; x < list.size(); x++) {
            String s = (String) list.get(x);
            System.out.println(s);
        }
    }
}
```

### 8-List集合存储自定义对象并遍历?(迭代器和普通for)

```java
package my_work;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListAndUserObject {
    public static void main(String[] args) {
        List list = new ArrayList();

        Student s1 = new Student(18, "wzy");
        Student s2 = new Student(19, "wzy");
        Student s3 = new Student(20, "wzy");

        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(new Student(24, "wzy"));
        
        // 遍历方式1:while
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Student s = (Student) it.next();
            System.out.println(s.getAge() + "- - - " + s.getName());
        }
        // 遍历方式2:size与get
        for (int x = 0; x < list.size(); x++) {
            Student stu = (Student) list.get(x);
            System.out.println(stu);
        }
    }
}
```

### 9-并发修改异常ConcurrentModificationException出现的原因?解决方案?

出现在当迭代器对进行遍历时，我想在程序中加入一个判断，如果这个判断成立，则在集合中添加一个新的元素，这时就会出现并发修改异常错误ConcurrentModificationException：

- 迭代器拿到的只是一个集合的拷贝，但是此时已经出现了一个新的集合
- 迭代器在进行迭代时并不知道集合已经发生了变化
- 迭代器依旧按照原始计划工作

**如何解决？**

（1）在循环中使用List类特有的迭代器ListIterator()添加新的元素，如下：

```java
package my_work;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListExcepiton {
    public static void main(String[] args) {
        List list = new ArrayList();

        list.add("Hello");
        list.add("world");
        list.add("java");

        ListIterator lit = list.listIterator();

        while (lit.hasNext()){
            if ("world".equals(lit.next())){
                lit.add("JavaSE");
            }
        }
        System.out.println(list); // [Hello, world, JavaSE, java]，虽然是在迭代器中添加，但是，也会在最终的打印环节显示。
    }
}
```

（2）使用普通的for循环，在list里直接添加

```java
package my_work;

import java.util.ArrayList;
import java.util.List;

public class ListExceptionFor {
    public static void main(String[] args) {
        List list = new ArrayList();

        list.add("Hello");
        list.add("world");
        list.add("java");

        for (int x = 0; x < list.size(); x++){
            if ("world".equals(list.get(x))){
                list.add("JavaSE");
            }
        }
        System.out.println(list);
    }
}
```

### 10-常见的数据结构的特点?

（1）栈：

就像一个步枪弹匣，出口和入口为同一个，遵循先进后出原则，进出对应着入栈和弹栈

（2）队列：

队列就像隧道里的汽车，遵循先后规则进出，入口与出口不共用

（3）数组：

存储同一种数据类型的容器，具备索引下标，但是删除指定元素和增加指定元素耗时，查询快，增删慢

（4）链表：

链表和结点一起出现；

链表：将结点串起来的链子，使用地址值充当这个串起来的链子；

结点：结点中存储着地址与数据，多个节点之间的地址存放总是相互关联的；

链表也分为双向链表、单向链表....

链表的存储快，删除快，查询慢。

### 11-List集合的子类特点

（1）ArrayList：底层数据类型是数组结构，增删慢，查询快，线程不安全，执行效率高；

（2）Vector：底层数据类型是数组结构，增删慢，查询快，线程安全，执行效率低；

（3）LinkedList：底层数据结构是链表，增删快，查询慢，线程不安全，执行效率高

### 12-List的三个儿子你准备使用谁?请说明理由。

有关List的使用，

（1）在存储需求出现时，优先考虑LinkedList；

（2）在查询需求出现时，优先考虑ArrayList；

Vector类一般不使用，它出现在JDK1.0，古老的玩意，ArraysList的出现就是为了代替Vector类，虽然说Vector是List的儿子，但是儿子和儿子之间，Vector却是LinkedList和ArrayList的爷爷；