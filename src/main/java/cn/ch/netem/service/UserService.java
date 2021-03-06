package cn.ch.netem.service;

import java.util.List;

import cn.ch.netem.pojo.Page;
import cn.ch.netem.pojo.User;

public interface UserService {

	public void login(String user,String  password) ;
    public List<User> findUserAll(String userCode,String userName,Page page,Integer userType);
    public int addUser(User user,String url);
    public int activationUser(String userCode);
    public int delUset(Integer id);
   public String addAdmin(User user);
}
