package register.dao;

import register.pojo.User;

public interface UserDao {
    /**
     * ������Ҫ���������ӿ�
     * ��1��ע��
     * ��2����¼*/
    public abstract void register(User u);

    public abstract boolean isLogin(String name,String password);
}
