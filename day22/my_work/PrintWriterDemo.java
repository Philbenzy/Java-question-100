package my_work;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterDemo {
    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter("fw.txt"),true);

        pw.println("hello");
        pw.println(true);
        pw.println(100);
        pw.println(1000);

    }
}
