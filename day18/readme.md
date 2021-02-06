## JavaDay18 Map

本节学习到的有：

（1）HashMap

（2）TreeMap

（3）Collection工具类

## 1-关于Map类

关于Mapl类需要知道的有：

- Map类是一种双列集合，被称为键与值
- 键在集合中保持唯一，值可以重复
- 在Map中，所有的数据关系仅对键有效
- 在进行Map集合的遍历时可以使用两种方法进行，键找值法，键值对法。

### 2-HashMap

（1）特点

底层为哈希表结构，使用equals()方法和compareTo()方法确保键值唯一，

（2）功能

- keySet( )：得到键集合
- get(key)：得到键所对应的值

（3）HashMap练习

- HashMap<String,String>：HashMapStringWithString.java
- HashMap<Integer,String>：HashMapIntegerWithString.java
- HashMap<String,自定义对象>：值为对象HashMapStringWithObject.java
- HashMap<自定义对象,String>：键为对象HashMapObjectWithString.java **注意：需要重写方法保证唯一性**

### 3-TreeMap

（1）特点

底层为红黑树结构实现，具有对元素排序的功能，在排序时返回0则可以帮助我们去掉重复键值元素，

排序方式可以由**元素自身实现**或**比较器实现**完成。

（2）功能

- keySet( )：得到键集合
- get(key)：得到键所对应的值

（3）练习

- TreeMap<String,String>：TreeMapStringWithString.java
- TreeMap<Student,String>：TreeMapStudentWithString.java,**注意：使用比较器进行年龄排序**
- 使用TreeMap统计字符串中字母出现的次数：CountKeyBoardTime.java

### 4-Map集合的遍历

（1）用**键**找值

UseKeyFindValue.java

```java
package my_work;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// 使用键对map进行遍历
public class UseKeyFindValue {
    public static void main(String[] args) {
        Map<String, String> hp = new HashMap<>();

        hp.put("邓超", "孙俪");
        hp.put("黄晓明", "杨颖");
        hp.put("周杰伦", "蔡依林");
        hp.put("刘恺威", "杨幂");

        // 使用「键」对集合进行遍历
        Set<String> s = hp.keySet(); // 将键组合成为一个集合
        for (String str : s){
            System.out.println(str+"- - - "+hp.get(str));
        }
    }
}
```

（2）用**键值对**找键与值

UseMapFindValue.java

```java
package my_work;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UseMapFindValue {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();

        map.put("杨过", "小龙女");
        map.put("郭靖", "黄蓉");
        map.put("杨康", "穆念慈");
        map.put("陈玄风", "梅超风");

        Set<Map.Entry<String,String>> s = map.entrySet();
        for (Map.Entry<String,String> s2 : s){
            String name = s2.getKey();
            String value = s2.getValue();
            System.out.println("name: "+name+" value: "+value);
        }
    }
}
```

（3）案例演示：集合的嵌套遍历

- HashMap嵌套HashMap 案例演示：HashMapLoopInsert.java

- HashMap嵌套ArrayList 案例演示：HashMapLoopWithArrayList.java

### 5-Collections工具类

（1）Collection和Collections的区别

- Collection是顶层接口，它的子类接口有两个，分别为List和Set

- Collections中封装了关于集合对象操作的类，可以进行排序与查找

（2）Collection类与Map类的区别

- Collection类为单列集合的顶层接口,Map类为双列集合的的顶层接口
- Collection元素单个出现，Map中的元素以键值对方式匹配，数据结构只针对键

（3）Collections常用方法

* public static \<T> void sort(List\<T> list)：排序 默认情况下是自然顺序。
* public static \<T> int binarySearch(List<?> list,T key):二分查找
* public static \<T> T max(Collection<?> coll):最大值
* public static void reverse(List<?> list):反转
* public static void shuffle(List<?> list):随机置换



