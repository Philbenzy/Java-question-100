package register.dao;

import register.pojo.User;

public interface UserDao {
    /**
     * 这里需要定义两个接口
     * （1）注册
     * （2）登录*/
    public abstract void register(User u);

    public abstract boolean isLogin(String name,String password);
}
