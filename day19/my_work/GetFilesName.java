package my_work;

// �жϵ�ǰĿ¼���Ƿ��к�׺��Ϊ.txt���ļ�������У���������ļ�����
// (1) ����1���Ȼ�ȡ���еģ��ڱ�����ʱ���жϣ������
// (2) ����2�����жϣ��ٻ�ȡ�����ֱ�ӱ����������

import java.io.File;

public class GetFilesName {
    public static void main(String[] args) {
        File file = new File("homework");

        // ��ȡ�ļ�����
        File[] filesArray = file.listFiles();

        for (File f : filesArray){

            // �����ж�
            if (f.isFile()){
                if (f.getName().endsWith("txt")){
                    System.out.println(f.getName());
                }
            }
        }
    }
}
