package com.vayber.smbms.service.role;

import com.vayber.smbms.dao.Role.RoleMapper;
import com.vayber.smbms.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{

   @Autowired
   private RoleMapper roleMapper;


    public List<Role> getRoleList() throws SQLException {
        return roleMapper.getRoleList();
    }
}
