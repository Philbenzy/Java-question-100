package my_work;

// ��1���õ����е��ļ����ƣ���ʹ���ļ����ƹ������õ�Ŀ���ļ�

import java.io.File;
import java.io.FilenameFilter;


public class GetFilesName2 {
    public static void main(String[] args) {

        File file = new File("homework");
        String[] strFile = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return new File(dir,name).isFile() && name.endsWith("txt");
            }
        });

        for (String s : strFile){
            System.out.println(s);
        }

    }
}
