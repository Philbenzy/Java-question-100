package my_work;

import java.io.*;

// �����༶�ļ���
public class MyCopyFolder {
    public static void main(String[] args) throws IOException {
        File srcFile = new File("my_work");
        File desFile = new File("C:\\Users\\Wzy\\Desktop\\data");

        // �����ļ���
        copyFolder(srcFile,desFile);
    }

    private static void copyFolder(File srcFile, File desFile) throws IOException {

        if (srcFile.isDirectory()){
            // ��1��������ļ��У��򴴽�
            File newFolder = new File(desFile,srcFile.getName());
            newFolder.mkdir();

            // ��2����ȡ�ļ����ڵ��ļ���������������ļ��У���ݹ飬���Ƶ�ָ��Ŀ¼
            File[] fileArray = srcFile.listFiles();
            for (File file: fileArray){
                copyFolder(file,newFolder);
            }
        }else {
            // (3)������ļ�����ʹ���ֽ�������
            File newFile = new File(desFile,srcFile.getName());
            // (4)�����ļ�����
            copyFile(srcFile, newFile);
        }
    }

    private static void copyFile(File srcFile, File desFile) throws IOException {

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(desFile));

        byte[] bys = new byte[1024];
        int len =0;
        while ((len=bis.read(bys))!=-1){
            bos.write(bys,0,len);
        }
        bos.close();
        bis.close();
    }
}
