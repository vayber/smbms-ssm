package com.vayber.smbms.dao.User;


import com.vayber.smbms.pojo.User;
import org.apache.ibatis.annotations.Param;
import java.sql.SQLException;
import java.util.List;

public interface UserMapper {

    //得到要登录的用户
    public User getLoginUser(@Param("userCode") String userCode, @Param("userPassword") String userPassword) throws SQLException;

    //修改用户密码
    public int updateUserPassword(@Param("id") int id, @Param("password") String password) throws  SQLException;

    //获取用户数量(根据用户名或者角色)
    public  int getUserCount( @Param("userName") String username, @Param("userRole") int userRole) throws  SQLException;

    //通过条件查询获取用户列表 搜索框
    public List<User> getUserList(@Param("userName") String username, @Param("userRole") int userRole) throws  SQLException;

    //增加用户
    public int addUser( User user) throws  SQLException;

    //删除用户
    public int deleteUser( int id) throws  SQLException;

    //修改用户
    public int modifyUser(User user) throws SQLException;

    //查询用户
    public User getQueryUser( int id) throws SQLException;


}
