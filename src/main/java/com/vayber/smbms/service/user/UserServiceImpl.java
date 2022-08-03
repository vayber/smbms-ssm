package com.vayber.smbms.service.user;

import com.vayber.smbms.dao.User.UserMapper;
import com.vayber.smbms.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;


@Service
public class UserServiceImpl implements UserService{

    //自动装配UserMapper实现类 只要spring容器中有这个bean
    @Autowired
    private  UserMapper userMapper;


    public User getLoginUser(String userCode, String userPassword) throws SQLException {

        return userMapper.getLoginUser(userCode,userPassword);
    }

    public int updateUserPassword(int id, String password) throws SQLException {
        return userMapper.updateUserPassword(id,password);
    }

    public int getUserCount(String username, int userRole) throws SQLException {
        return userMapper.getUserCount(username, userRole);
    }

    public List<User> getUserList(String username, int userRole) throws SQLException {
        return userMapper.getUserList(username,userRole);
    }

    public int addUser(User user) throws SQLException {
        return userMapper.addUser(user);
    }

    public int deleteUser(int id) throws SQLException {
        return userMapper.deleteUser(id);
    }

    public int modifyUser(User user) throws SQLException {
        return userMapper.modifyUser(user);
    }

    public User getQueryUser(int id) throws SQLException {
        return userMapper.getQueryUser(id);
    }

}
