package com.vayber.smbms.dao.Role;

import com.vayber.smbms.pojo.Role;

import java.sql.SQLException;
import java.util.List;

public interface RoleMapper {
    //获取角色列表    下拉框选项
    public List<Role> getRoleList() throws SQLException;
}
