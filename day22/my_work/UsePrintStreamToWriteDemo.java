package my_work;

import java.io.*;

/**
 * ʹ�ô�ӡ��������ݵ�д��
 * ˵����
 *      ��1��BufferedReader��BufferedWriter���·�����readLine��newLine*/
public class UsePrintStreamToWriteDemo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("name.txt"));

        // ԭʼд��
        // BufferedWriter bw = new BufferedWriter(new FileWriter("name_copy.txt"));

        PrintWriter pw = new PrintWriter(new FileWriter("name_copy.txt"),true);// �Զ�ˢ��

        String line = null;
        while ((line=br.readLine())!=null){
            // ��ӡ����println������newLine,����flush
            pw.println(line);
        }

        br.close();
        pw.close();
    }
}
