package my_work;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class MyPropertiesDemo {
    public static void main(String[] args) throws IOException {
        Properties prop = new Properties();
        FileReader fr = new FileReader("user.txt");

        prop.load(fr);
        fr.close();

        Set<String> set = prop.stringPropertyNames(); // 特有功能得到键视图
        for (String key : set){
            if ("wangziyu".equals(key)){
                prop.setProperty(key,"1001");
            }
        }
        FileWriter fw = new FileWriter("user.txt");
        prop.store(fw,"第一次修改");
    }
}
