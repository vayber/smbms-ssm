package com.vayber.smbms.service.user;

import com.vayber.smbms.pojo.User;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;


public interface UserService {
    //得到要登录的用户
    public User getLoginUser(String userCode, String userPassword) throws SQLException;

    //修改用户密码
    public int updateUserPassword( int id, String password) throws  SQLException;

    //获取用户数量(根据用户名或者角色)
    public  int getUserCount( String username, int userRole) throws  SQLException;

    //通过条件查询获取用户列表 搜索框
    public List<User> getUserList(String username, int userRole) throws  SQLException;

    //增加用户
    public int addUser( User user) throws  SQLException;

    //删除用户
    public int deleteUser( int id) throws  SQLException;

    //修改用户
    public int modifyUser(User user) throws SQLException;

    //查询用户
    public User getQueryUser( int id) throws SQLException;
}
