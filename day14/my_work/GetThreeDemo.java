package my_work;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * ��ȡһ�仰�������ַ�����ƴ��
 * ˼·��
 * ��1����������ƥ�����
 * ��2������ģʽ���󣬴���ƥ�����
 * ��3������ƥ�������󣬴����ַ�
 * ��4������������m.find�����������ж�
 * ��5���жϳɹ���ʹ��m.group���������ַ���
 * ע�⣺
 * ��1��find����Ӧ����group��������ǰ�����ж��Ƿ���ڣ��ٵ���
 * ��2)ƥ���������group���������ҵ����ַ���
 * */


public class GetThreeDemo {
    public static void main(String[] args) {
        String s = "da jia ting wo shuo,jin tian yao xia yu,bu shang wan zi xi,gao xing bu?";
        String regex = "\\b\\w{3}\\b"; // �ַ����ߵı�ʾ

        // ����ģʽ����
        Pattern p = Pattern.compile(regex);
        // ����ƥ��������
        Matcher m = p.matcher(s);
        while (m.find()){
            System.out.println(m.group());
        }
    }
}
