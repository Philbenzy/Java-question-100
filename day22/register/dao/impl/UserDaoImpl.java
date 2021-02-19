package register.dao.impl;

import register.pojo.User;
import register.dao.UserDao;

import java.io.*;

public class UserDaoImpl implements UserDao {
    // IO���洢�ļ���Ŀ¼��ַ
    private static File file = new File("myWork_user.txt");

    static {
        try{
            file.createNewFile();
        }catch (Exception e){
            System.out.println("�����ļ�ʧ�ܣ�");
            //e.printStackTrace();
        }
    }

    @Override
    public void register(User u) {
        BufferedWriter bw = null;

        try{
            bw = new BufferedWriter(new FileWriter(file,true)); // ׷��д��
            bw.write(u.getName()+"="+u.getPassword());
            bw.newLine();
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try{
                bw.close();
            }catch (Exception e){
                System.out.println("�ر�д����ʧ�ܣ�");
            }
        }

    }

    @Override
    public boolean isLogin(String name, String password) {
        boolean flag = false;

        BufferedReader br = null;
        String line = null;
        try{
            br = new BufferedReader(new FileReader(file));
            while ((line = br.readLine())!=null){
                String[] data = line.split("="); // �õ�������û���������
                if (data[0].equals(name) && data[1].equals(password)){
                    flag = true;
                    break;
                }
            }
        }catch (FileNotFoundException f){
            System.out.println("�ļ��޷��ҵ�");

        } catch (IOException e) {
            System.out.println("��ȡ�ļ�ʧ�ܣ�");
        }finally {
            try{
                br.close();
            }catch(Exception e){
                System.out.println("�ͷ���Դʧ�ܣ�");
            }
        }


        return flag;
    }
}
