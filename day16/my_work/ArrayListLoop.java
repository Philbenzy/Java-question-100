package my_work;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用集合嵌套进行对象(MyClassmate)装载，并且最后遍历集合
 */
public class ArrayListLoop {
    public static void main(String[] args) {

        ArrayList<MyClassmate> list = new ArrayList<>();
        // (1)建立对象
        MyClassmate mc1 = new MyClassmate("王老板", 18);
        MyClassmate mc2 = new MyClassmate("唐三藏", 50);
        MyClassmate mc3 = new MyClassmate("周杰伦", 18);
        // (2)添加对象进入集合
        list.add(mc1);
        list.add(mc2);
        list.add(mc3);

        ArrayList<MyClassmate> list2 = new ArrayList<>();
        MyClassmate mc4 = new MyClassmate("鲍勃迪伦", 88);
        MyClassmate mc5 = new MyClassmate("佛莱迪", 55);

        list2.add(mc4);
        list2.add(mc5);

        ArrayList<MyClassmate> list3 = new ArrayList<>();
        MyClassmate mc6 = new MyClassmate("王所银",22);
        MyClassmate mc7 = new MyClassmate("小猪猪",1);

        list3.add(mc6);
        list.add(mc7);

        // 添加对象进入大集合
        List<ArrayList<MyClassmate>> bigPersonList = new ArrayList<>();
        bigPersonList.add(list);
        bigPersonList.add(list2);
        bigPersonList.add(list3);

        //使用增强for循环遍历大集合
        for (ArrayList<MyClassmate> arr : bigPersonList) {
            for (MyClassmate s : arr) {
                System.out.println(s.getName()+"- - - "+s.getAge());
            }
        }

    }
}
