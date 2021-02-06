package my_work;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class CountKeyBoardTime {
    public static void main(String[] args) {

        // �������϶���
        // Ϊʲô��TreeMap? ��ΪTreeMap���Ա�֤���ֵļ�Ψһ������������ͳ��˼��
        TreeMap<Character,Integer> map = new TreeMap<>();

        // ����¼���ַ���
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        // ���ַ���תΪ�ַ�����
        char[] chs = str.toCharArray();

        // �������
        for (char ch: chs){
           Integer i  = map.get(ch);
           if (i==null){
               map.put(ch,1);
           }else{
               i++;
               map.put(ch,i);
           }
        }

        // �������ӵ�StringBuilder�У�Ϊ�����׼��
        StringBuilder sb = new StringBuilder();

        Set<Character> keySet = map.keySet();
        for (Character key: keySet){
            Integer value = map.get(key);
            sb.append(key).append("(").append(value).append(")");
        }

        String result = sb.toString();
        System.out.println(result);
    }
}
