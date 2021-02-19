package my_work;


import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropWithIO {
    public static void main(String[] args) throws IOException {
        Properties prop = new Properties();
        FileReader fr = new FileReader("my_work/prop.txt");

        prop.load(fr);

        fr.close();
        System.out.println("prop: "+prop);

    }
}
