package my_work;

import java.io.*;

// 拷贝多级文件夹
public class MyCopyFolder {
    public static void main(String[] args) throws IOException {
        File srcFile = new File("my_work");
        File desFile = new File("C:\\Users\\Wzy\\Desktop\\data");

        // 复制文件夹
        copyFolder(srcFile,desFile);
    }

    private static void copyFolder(File srcFile, File desFile) throws IOException {

        if (srcFile.isDirectory()){
            // （1）如果是文件夹，则创建
            File newFolder = new File(desFile,srcFile.getName());
            newFolder.mkdir();

            // （2）获取文件夹内的文件对象，如果继续是文件夹，则递归，复制到指定目录
            File[] fileArray = srcFile.listFiles();
            for (File file: fileArray){
                copyFolder(file,newFolder);
            }
        }else {
            // (3)如果是文件，则使用字节流复制
            File newFile = new File(desFile,srcFile.getName());
            // (4)复制文件内容
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
