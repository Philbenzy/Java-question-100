package my_work.genericWithInter;
// 泛型的出现是为了解决之前从集合取出元素时，需要进行强制转换这一问题，例如可能Integer类型转换为String类型，这是一个明显不可以的操作！
// 泛型出现时，可以让编译器尽早、尽快报错，而不需要等到执行的时候

// 在实现接口时:
// 1：已经知道要实现什么类型的了
//public class InterImp implements Inter<String> {
//    public void show(String s){
//        System.out.println(s);
//    }
//}

// 2 并不知道要实现什么类型的时候，需要在类名之后加入泛型
public class InterImp<T> implements Inter<T> {
    @Override
    public void show(T t) {
        System.out.println(t);
    }
}
/*
 * 1 泛型定义在类上
 *   ：在新建这个新类时，需要我们指定这个类的泛型具体是什么
 * 2 泛型定义在方法上
 *   ：新建类然后使用这个方法即可，方法则返回你传入类型的值
 * 3 泛型定义在接口上
 * 3.1 在实现过程中，
 *   （1）知道需要实现什么类的接口
 *       这时候在现实子类上明确具体的类型
 *   （2）并不知道需要实现什么类的接口
 *       这时候需在实现子类上声明我还不知道，注意写法，等到具体新建这个实现接口的子类时，再明确类别*/
