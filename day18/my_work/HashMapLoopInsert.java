package my_work;

import java.util.HashMap;
import java.util.Set;

// ʹ��HashMap��Ƕ�ף�ʵ�ִ洢Сѧ����е�ѧ��
/*
* Сѧ
*       WZY
*       С��
*       С��
* ����
*       ţүү
*       �ڰ��
*       ������ */
public class HashMapLoopInsert {
    public static void main(String[] args) {
        HashMap<String, HashMap<String, Integer>> school = new HashMap<>();

        HashMap<String, Integer> littleSchool = new HashMap<>();


        littleSchool.put("WZY", 6);
        littleSchool.put("С��", 6);
        littleSchool.put("С��", 6);

        school.put("Сѧ", littleSchool);

        HashMap<String,Integer> mediaSchool = new HashMap<>();

        mediaSchool.put("ţүү",75);
        mediaSchool.put("�ڰ��",65);
        mediaSchool.put("������",55);

        school.put("����",mediaSchool);

        Set<String> schoolKeySet = school.keySet(); // �õ��༶������
        for (String schoolKey : schoolKeySet){
            System.out.println(schoolKey+": ");
            HashMap<String,Integer> classValueMap = school.get(schoolKey); // �õ���Ӧ��ֵ����һ��map��
            Set<String> classKeySet = classValueMap.keySet(); // �����õ����ļ���
            for (String classKey : classKeySet){
                Integer i = classValueMap.get(classKey); // ʹ�ü������õ���Ӧֵ��Ȼ���ӡ
                System.out.println("\t"+classKey+" - - - "+i);
            }
        }
    }
}
