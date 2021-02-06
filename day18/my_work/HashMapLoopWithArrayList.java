package my_work;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class HashMapLoopWithArrayList {
    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> hm = new HashMap<>();
        ArrayList<String> array1 = new ArrayList<>();

        array1.add("����");
        array1.add("�Ϻ�");
        array1.add("����");

        ArrayList<String> array2 = new ArrayList<>();

        array2.add("��ɽ");
        array2.add("��ɽ");
        array2.add("��ɽ");

        hm.put("��",array1);
        hm.put("ɽ",array2);

        Set<String> keySet = hm.keySet();
        for (String key: keySet){
            ArrayList<String>  value = hm.get(key);
            System.out.println(key);
            for (String s : value){
                System.out.println("\t"+s);
            }
        }

    }





}
