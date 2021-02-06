package my_work;

import java.util.HashMap;
import java.util.Set;

// 使用HashMap的嵌套，实现存储小学与初中的学生
/*
* 小学
*       WZY
*       小花
*       小明
* 初中
*       牛爷爷
*       黑帮狂花
*       黑旋风 */
public class HashMapLoopInsert {
    public static void main(String[] args) {
        HashMap<String, HashMap<String, Integer>> school = new HashMap<>();

        HashMap<String, Integer> littleSchool = new HashMap<>();


        littleSchool.put("WZY", 6);
        littleSchool.put("小花", 6);
        littleSchool.put("小明", 6);

        school.put("小学", littleSchool);

        HashMap<String,Integer> mediaSchool = new HashMap<>();

        mediaSchool.put("牛爷爷",75);
        mediaSchool.put("黑帮狂花",65);
        mediaSchool.put("黑旋风",55);

        school.put("初中",mediaSchool);

        Set<String> schoolKeySet = school.keySet(); // 得到班级键集合
        for (String schoolKey : schoolKeySet){
            System.out.println(schoolKey+": ");
            HashMap<String,Integer> classValueMap = school.get(schoolKey); // 得到对应的值（另一个map）
            Set<String> classKeySet = classValueMap.keySet(); // 继续得到键的集合
            for (String classKey : classKeySet){
                Integer i = classValueMap.get(classKey); // 使用键继续得到对应值，然后打印
                System.out.println("\t"+classKey+" - - - "+i);
            }
        }
    }
}
