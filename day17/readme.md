## JavaDay17 Collection(Set集合)

### 1-Set集合

（1）Set类的特点

- Set类中存储的对象元素必须是唯一的
- Set类不存储对象进入Set的顺序，Set有属于自己的排序方式

（2）Set的子类

- HashSet
- TreeSet

### 2-HashSet

（1）HashSet特点

HashSet中存储的元素可以依照HashSet内的方法保证录入的元素唯一。

（2）HashSet底层？

HashSet的底层是通过**哈希表**实现的

（3）HashSet何如保证元素唯一性？

```java
// 在HashMap中add方法的相关源码：
int i = indexFor(hash, table.length);
        for (Entry<K,V> e = table[i]; e != null; e = e.next) {
            Object k;
            if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
                V oldValue = e.value;
                e.value = value;
                e.recordAccess(this);
                return oldValue;
                //走这里其实是没有添加元素
            }
        }

        modCount++;
        addEntry(hash, key, value, i); //把元素添加
        return null;
    }

```

可以看到，这里的「e.hash == hash && ((k = e.key) == key || key.equals(k)」比较的东西一般有三个（1）hash值比较 「与」（（2）地址比较「或」（3）equals比较），条件为真则不添加。

**总结：**

- HashSet中需要我们对存储对象进行方法的重写
  - hashCode( )方法
  - equals( )方法

但是不要担心，这两个方法都是可以通过IDE自动生成的，但是我们需要知道HashSet是如何保证集合元素唯一的。

**进行的流程：**

- 判断是否Hash值相同？
  - true：执行equals比较
    - true：元素重复，不添加
    - false：添加元素
  - false：添加元素进入集合



### 3-TreeSet

（1）TreeSet的特点

TreeSet可以保证元素的唯一性，TreeSet有两种构造方法的提供，给我们提供两种不同的方式实现元素排序（同时特保证了唯一性）

（2）TreeSet底层结构

红黑树（自平衡的二叉树），可以保证查找层级不会出现很多而耗费时间。

（3）TreeSet对元素排序的方式（两种）？应该怎么做（两种）？

- 自然顺序排序
- 比较器排序

**自然顺序排序：**

1. 需要存储类实现comparable接口
2. 实现compareTo( )方法，需要说明的是：
   1. return 1 表示成为红黑树的右孩子
   2. return -1 表示成为红黑树的左孩子
   3. return 0 表示不录入这个元素，保证元素的唯一性 

**比较器排序：**

1. 依照特定规则构造一个具体的比较器对象（实现comparator接口，重写compare方法）
2. 将这个比较器对象传入TreeSet中

注意：一般不将这个比较器对象定义成外部类，使用匿名类进行传递很方便，推荐这样做

### 4-Collection集合总结

- Collection
  - List：元素可以重复，保存存入的顺序
    - ArrayList
    - Vector
    - LinkedList
  - Set：元素不可以重复，不保存存入的顺序
    - HashSet
    - TreeSet
    - LinkedHashSet

### 5-案例演示

（1）HashSet存储字符串并遍历（基本对象）

案例演示：「HashSetStorageString.java」

（2）HashSet存储自定义对象并遍历（对象的成员变量值相同即为同一个元素）

案例演示：「HashSetStorageObject.java」其中使用到了「Person.java」类作为演示

（3）TreeSet集合，获取无重复的随机数

案例演示：「TreeSetWithRandomNumber.java」

在（3）这个例子中，使用到了Integer类型，所以没有在类型中实现接口重写CompareTo方法，或者传入Compartor方法。

（4）学生按照总分从高到底输出

案例演示：「StudentWithComparable.java」

- Student类继承Comparable接口

（5）学生按照总分从高到底输出

案例演示：「StudentWithComparable.java」

- TreeSet中传入匿名对象Comparator，完成比较









