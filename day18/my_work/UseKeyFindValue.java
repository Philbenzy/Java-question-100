package my_work;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// ʹ�ü���map���б���
public class UseKeyFindValue {
    public static void main(String[] args) {
        Map<String, String> hp = new HashMap<>();

        hp.put("�˳�", "��ٳ");
        hp.put("������", "��ӱ");
        hp.put("�ܽ���", "������");
        hp.put("������", "����");

        // ʹ�á������Լ��Ͻ��б���
        Set<String> s = hp.keySet(); // ������ϳ�Ϊһ������
        for (String str : s){
            System.out.println(str+"- - - "+hp.get(str));
        }

    }
}
