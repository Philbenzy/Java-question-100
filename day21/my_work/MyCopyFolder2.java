package my_work;

import java.io.*;

public class MyCopyFolder2 {
    public static void main(String[] args) throws IOException {
        File srcFile = new File("my_work");
        File desFile = new File("C:\\Users\\Wzy\\Desktop\\data");

        copyFolder(srcFile, desFile);
    }

    private static void copyFolder(File srcFile, File desFile) throws IOException {

        if (srcFile.isDirectory()){
            File newFolder = new File(desFile,srcFile.getName());
            newFolder.mkdir();

            File[] fileArray = srcFile.listFiles();
            for (File file: fileArray){
                copyFolder(file,newFolder);
            }
        }else {
            File newFile = new File(desFile,srcFile.getName());
            copyFile(srcFile,newFile);
        }

    }

    private static void copyFile(File srcFile, File desFile) throws IOException {

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(desFile));

        byte[] bys = new byte[1024];
        int len = 0;
        while ((len = bis.read(bys)) != -1) {
            bos.write(bys, 0, len);
        }
        bos.close();
        bis.close();
    }

}
