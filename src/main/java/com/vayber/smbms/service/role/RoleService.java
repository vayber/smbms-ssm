package com.vayber.smbms.service.role;

import com.vayber.smbms.pojo.Role;

import java.sql.SQLException;
import java.util.List;

public interface RoleService {
    //得到用户列表
    public List<Role> getRoleList() throws SQLException;

}
