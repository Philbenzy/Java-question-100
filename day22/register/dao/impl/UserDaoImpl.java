package register.dao.impl;

import register.pojo.User;
import register.dao.UserDao;

import java.io.*;

public class UserDaoImpl implements UserDao {
    // IO流存储文件的目录地址
    private static File file = new File("myWork_user.txt");

    static {
        try{
            file.createNewFile();
        }catch (Exception e){
            System.out.println("创建文件失败！");
            //e.printStackTrace();
        }
    }

    @Override
    public void register(User u) {
        BufferedWriter bw = null;

        try{
            bw = new BufferedWriter(new FileWriter(file,true)); // 追加写入
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
                System.out.println("关闭写入流失败！");
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
                String[] data = line.split("="); // 得到储存的用户名与密码
                if (data[0].equals(name) && data[1].equals(password)){
                    flag = true;
                    break;
                }
            }
        }catch (FileNotFoundException f){
            System.out.println("文件无法找到");

        } catch (IOException e) {
            System.out.println("读取文件失败！");
        }finally {
            try{
                br.close();
            }catch(Exception e){
                System.out.println("释放资源失败！");
            }
        }


        return flag;
    }
}
