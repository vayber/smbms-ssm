package com.vayber.smbms.controller;


import com.alibaba.fastjson.JSON;
import com.vayber.smbms.pojo.User;
import com.vayber.smbms.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;


@Controller
@RequestMapping("/management.do")
public class UserController {

        @Autowired
        private UserService userServiceImpl;


        //查询用户列表
        @RequestMapping("/queryList")
        @ResponseBody
        public String queryList(HttpServletRequest req) throws ServletException, IOException, SQLException {

                //从前端获取数据
                String queryUserName = req.getParameter("queryname");
                String temp = req.getParameter("queryUserRolesss");

                int queryUserRole = 0;

                //获取用户列表

                List<User> userList = null;


                if (queryUserName == null){ //给查询赋值
                        queryUserName = "";
                }
                //int queryUserRole = 0   下拉框不选择默认是0 如果选了就走下面if 赋选择的值
                if (temp != null && !temp.equals("")){   //给下拉框赋值
                        queryUserRole = Integer.parseInt(temp);
                }


                //获取用户列表展示
                userList = userServiceImpl.getUserList(queryUserName, queryUserRole);

                return JSON.toJSONString(userList);

        }

        //查询用户数量
        ///getUserCount
        @RequestMapping("/getUserCount")
        @ResponseBody
        public String getUserCount(HttpServletRequest req) throws ServletException, IOException, SQLException {

                //从前端获取数据
                String queryUserName = req.getParameter("queryname");
                String temp = req.getParameter("queryUserRolesss");


                int queryUserRole = 0;


                if (queryUserName == null){ //给查询赋值
                        queryUserName = "";
                }
                //int queryUserRole = 0   下拉框不选择默认是0 如果选了就走下面if 赋选择的值
                if (temp != null && !temp.equals("")){   //给下拉框赋值
                        queryUserRole = Integer.parseInt(temp);
                }


                //获取用户列表展示

                int userCount = userServiceImpl.getUserCount(queryUserName, queryUserRole);

                System.out.println(userCount);

                return JSON.toJSONString(userCount);
        }

        //增加用户
        @RequestMapping("/add")
        @ResponseBody
        public String add(HttpServletRequest req) throws IOException {

                String userCode = req.getParameter("userCode");
                String userName = req.getParameter("userName");
                String userPassword = req.getParameter("userPassword");
                String userAge = req.getParameter("userAge");
                String gender = req.getParameter("gender");
                String birthday = req.getParameter("birthday");
                String phone = req.getParameter("phone");
                String address = req.getParameter("address");
                String queryUserRole = req.getParameter("queryUserRole");

                String createdBy = req.getParameter("createdBy");


                java.util.Date date = new java.util.Date();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
                String creationDate = simpleDateFormat.format(date);

                User user = new User();
                user.setUserCode(userCode);
                user.setUserName(userName);
                user.setUserPassword(userPassword);
                user.setAge(Integer.parseInt(userAge));
                user.setGender(Integer.parseInt(gender));
                user.setBirthday(Date.valueOf(birthday));
                user.setPhone(phone);
                user.setAddress(address);
                user.setUserRole(Integer.parseInt(queryUserRole));
                user.setCreatedBy(Long.parseLong(createdBy));
                user.setCreationDate(creationDate);




                String result = "";
                int b = -1;

                try {
                        b =  userServiceImpl.addUser(user);

                } catch (Exception e) {
                        e.printStackTrace();
                }

                if (b == 1){
                        result = "add success";
                }else {
                        result = "add failure";
                }


                return JSON.toJSONString(result);

        }

        //删除用户
        @RequestMapping("/delete")
        @ResponseBody
        public String delete(HttpServletRequest req) throws IOException, SQLException {
                String uid = req.getParameter("uid");

                int b = -1;
                 b = userServiceImpl.deleteUser(Integer.parseInt(uid));

                String result = "";


                if (b != -1){
                        result = "true";
                }else {
                        result = "false";
                }

                return JSON.toJSONString(result);


        }


        //修改用户
        @RequestMapping("/modify")
        @ResponseBody
        public String modify(HttpServletRequest req) throws IOException {
                String id = req.getParameter("id");

                String userName = req.getParameter("userName");
                String gender = req.getParameter("gender");
                String age = req.getParameter("age");
                String phone = req.getParameter("phone");
                String address = req.getParameter("address");
                String userRole = req.getParameter("userRole");
                String modifyBy = req.getParameter("modifyBy");

                java.util.Date date = new java.util.Date();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String modifyDate = simpleDateFormat.format(date);


                User user = new User();
                user.setId(Long.parseLong(id));
                user.setUserName(userName);
                user.setGender(Integer.parseInt(gender));
                user.setAge(Integer.parseInt(age));
                user.setPhone(phone);
                user.setAddress(address);
                user.setUserRole(Integer.parseInt(userRole));
                user.setModifyBy(Long.parseLong(modifyBy));
                user.setModifyDate(modifyDate);



                int b = -1;
                String result = "";

                try {
                        b = userServiceImpl.modifyUser(user);
                } catch (Exception throwables) {
                        throwables.printStackTrace();
                }

                if (b != -1){
                        result = "alter success!";
                }else {

                        result = "alter failure!";
                }


           return JSON.toJSONString(result);

        }

}
