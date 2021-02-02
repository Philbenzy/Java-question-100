package my_work;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LoopForIteratorForpp {
    public static void main(String[] args) {
        List<MyClassmate> list = new ArrayList<MyClassmate>();
        MyClassmate mc = new MyClassmate("WZY",18);
        MyClassmate mc2 = new MyClassmate("WXK",18);
        list.add(mc);
        list.add(mc2);

        list.add(new MyClassmate("WZY",18));
        list.add(new MyClassmate("WXK",18));
        list.add(new MyClassmate("ZHH",18));
        list.add(new MyClassmate("LY",18));

        // 普通for
        for (int x = 0; x < list.size(); x++){
            MyClassmate mc3 = list.get(x);
            System.out.println(mc3.getName()+"- - - "+mc3.getAge());
        }

        //迭代器
        Iterator<MyClassmate> it = list.iterator();
        while (it.hasNext()){
            MyClassmate mm = it.next();
            System.out.println(mm.getName()+"- - - "+mm.getAge());
        }

        // 增强for
        for (MyClassmate m : list){
            System.out.println(m.getName()+"- - - "+m.getAge());
        }
    }
}
