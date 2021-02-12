package my_work;

import java.io.File;

public class GetAllJavaFileName {
    public static void main(String[] args) {

        File fileBasicPath = new File("C:\\Users\\Wzy\\My_work\\zy_Javase\\刘意Java\\配套资料\\day20");

        method(fileBasicPath);
    }

    public static void method(File file){
        // 获取当前所有对象
        File[] fileArray = file.listFiles();

        for (File f : fileArray){
            if (f.isDirectory()){
                method(f); // 递归的开始
                System.out.println(f.getName());

            }else {
                if (f.getName().endsWith(".java")||f.getName().endsWith(".class")||f.getName().endsWith(".txt")){
                    System.out.print("\t");
                    System.out.print("| --- ");
                    System.out.println(f.getName());
                }
            }
        }
    }
}
