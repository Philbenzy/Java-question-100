package my_work;

import java.util.ArrayList;
import java.util.List;

/**
 * ʹ�ü���Ƕ�׽��ж���(MyClassmate)װ�أ���������������
 */
public class ArrayListLoop {
    public static void main(String[] args) {

        ArrayList<MyClassmate> list = new ArrayList<>();
        // (1)��������
        MyClassmate mc1 = new MyClassmate("���ϰ�", 18);
        MyClassmate mc2 = new MyClassmate("������", 50);
        MyClassmate mc3 = new MyClassmate("�ܽ���", 18);
        // (2)��Ӷ�����뼯��
        list.add(mc1);
        list.add(mc2);
        list.add(mc3);

        ArrayList<MyClassmate> list2 = new ArrayList<>();
        MyClassmate mc4 = new MyClassmate("��������", 88);
        MyClassmate mc5 = new MyClassmate("������", 55);

        list2.add(mc4);
        list2.add(mc5);

        ArrayList<MyClassmate> list3 = new ArrayList<>();
        MyClassmate mc6 = new MyClassmate("������",22);
        MyClassmate mc7 = new MyClassmate("С����",1);

        list3.add(mc6);
        list.add(mc7);

        // ��Ӷ������󼯺�
        List<ArrayList<MyClassmate>> bigPersonList = new ArrayList<>();
        bigPersonList.add(list);
        bigPersonList.add(list2);
        bigPersonList.add(list3);

        //ʹ����ǿforѭ�������󼯺�
        for (ArrayList<MyClassmate> arr : bigPersonList) {
            for (MyClassmate s : arr) {
                System.out.println(s.getName()+"- - - "+s.getAge());
            }
        }

    }
}
