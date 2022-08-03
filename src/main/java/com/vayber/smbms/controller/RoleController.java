package com.vayber.smbms.controller;


import com.alibaba.fastjson.JSON;
import com.vayber.smbms.pojo.Role;
import com.vayber.smbms.service.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/roleManagement.do")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/queryList")
    @ResponseBody
    public String getRoleList() throws SQLException {
        List<Role> roleList = roleService.getRoleList();

        return JSON.toJSONString(roleList);
    }
}
