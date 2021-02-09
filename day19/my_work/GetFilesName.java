package my_work;

// 判断当前目录下是否有后缀名为.txt的文件，如果有，就输出此文件名称
// (1) 方法1：先获取所有的，在遍历的时候判断，再输出
// (2) 方法2：先判断，再获取，最后直接遍历输出即可

import java.io.File;

public class GetFilesName {
    public static void main(String[] args) {
        File file = new File("homework");

        // 获取文件对象
        File[] filesArray = file.listFiles();

        for (File f : filesArray){

            // 进行判断
            if (f.isFile()){
                if (f.getName().endsWith("txt")){
                    System.out.println(f.getName());
                }
            }
        }
    }
}
