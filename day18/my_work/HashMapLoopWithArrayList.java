package my_work;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class HashMapLoopWithArrayList {
    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> hm = new HashMap<>();
        ArrayList<String> array1 = new ArrayList<>();

        array1.add("东海");
        array1.add("南海");
        array1.add("北海");

        ArrayList<String> array2 = new ArrayList<>();

        array2.add("东山");
        array2.add("南山");
        array2.add("西山");

        hm.put("海",array1);
        hm.put("山",array2);

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
