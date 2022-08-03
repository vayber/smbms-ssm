package com.vayber.smbms.controller;

import com.alibaba.fastjson.JSON;
import com.vayber.smbms.pojo.Provider;
import com.vayber.smbms.service.provider.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/providerManagement.do")
public class ProviderController {


    @Autowired
    private ProviderService providerService;

    @RequestMapping("/getProviderCount")
    @ResponseBody
    public String getProviderCount(HttpServletRequest req) throws SQLException {

        String queryProCode = req.getParameter("queryProCode"); //查询供应商编码
        String queryProName = req.getParameter("queryProName"); //查询供应商名称


        //给查询赋值
        if (queryProCode == null){
            queryProCode = "";
        }
        if (queryProName == null){
            queryProName = "";
        }


        int providersCount = providerService.getProviderCount(queryProCode, queryProName);

        return JSON.toJSONString(providersCount);

    }

    @RequestMapping("/queryList")
    @ResponseBody
    public String getProviderList(HttpServletRequest req) throws SQLException{
        //从前端获取数据
        String queryProCode = req.getParameter("queryProCode"); //查询供应商编码
        String queryProName = req.getParameter("queryProName"); //查询供应商名称


        //给查询赋值
        if (queryProCode == null){
            queryProCode = "";
        }
        if (queryProName == null){
            queryProName = "";
        }




        //获取供应商列表
        List<Provider> providerList = providerService.getProviderList(queryProCode,queryProName);


        return JSON.toJSONString(providerList);
    }

    //获取供应商名称列表
    @RequestMapping("/getNameList")
    @ResponseBody
    public String getNameList(HttpServletRequest req) throws ServletException, IOException, SQLException {

        List<Provider> providerList = providerService.getProviderList(null,null);

        List<Provider> providerNameList = new ArrayList<Provider>();

        Provider provider = new Provider();

        for ( Provider p : providerList) {
            provider.setId(p.getId());
            provider.setProName(p.getProName());
            providerNameList.add(provider);
        }

        return JSON.toJSONString(providerNameList);

    }

    @RequestMapping("/add")
    @ResponseBody
    public String addProvider( HttpServletRequest req) throws  SQLException{
        String proCode = req.getParameter("proCode");
        String proName = req.getParameter("proName");
        String proDesc = req.getParameter("proDesc");
        String proContact = req.getParameter("proContact");
        String proPhone = req.getParameter("proPhone");
        String proAddress = req.getParameter("proAddress");
        String proFax = req.getParameter("proFax");
        String createdBy = req.getParameter("createdBy");

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String creationDate = simpleDateFormat.format(date);

        Provider provider = new Provider();
        provider.setProCode(proCode);
        provider.setProName(proName);
        provider.setProDesc(proDesc);
        provider.setProContact(proContact);
        provider.setProPhone(proPhone);
        provider.setProAddress(proAddress);
        provider.setProFax(proFax);
        provider.setCreatedBy(Long.parseLong(createdBy));
        provider.setCreationDate(creationDate);



        String result = "";
        int b = -1;

        try {
            b =  providerService.addProvider(provider);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        if (b == 1){
            result = "add success";
        }else {
            result = "add failure";
        }


        return JSON.toJSONString(result);

    }

    @RequestMapping("/delete")
    @ResponseBody
    public String deleteProvider(HttpServletRequest req) throws  SQLException{
        String proid = req.getParameter("proid");
        int b = -1;
        try {
            b = providerService.deleteProvider(Integer.parseInt(proid));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        String result = "";

        if (b == 1){
            result = "delete success";
        }else {
            result = "delete failure";
        }



        return JSON.toJSONString(result);

    }

    @RequestMapping("/modify")
    @ResponseBody
    public String modifyProvider(HttpServletRequest req) throws SQLException{
        String id = req.getParameter("id");
        String proCode = req.getParameter("proCode");
        String proName = req.getParameter("proName");
        String proDesc = req.getParameter("proDesc");
        String proContact = req.getParameter("proContact");
        String proPhone = req.getParameter("proPhone");
        String proAddress = req.getParameter("proAddress");
        String proFax = req.getParameter("proFax");
        String modifyBy = req.getParameter("modifyBy");

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String modifyDate = simpleDateFormat.format(date);

        Provider provider = new Provider();
        provider.setId(Long.parseLong(id));
        provider.setProCode(proCode);
        provider.setProName(proName);
        provider.setProDesc(proDesc);
        provider.setProContact(proContact);
        provider.setProPhone(proPhone);
        provider.setProAddress(proAddress);
        provider.setProFax(proFax);
        provider.setModifyBy(Long.parseLong(modifyBy));
        provider.setModifyDate(modifyDate);


       int b = -1;
        String result = "";

        try {
            b = providerService.modifyProvider(provider);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        if (b == 1){
            result = "alter success!";
        }else {

            result = "alter failure!";
        }



        return JSON.toJSONString(result);
    }


    @Deprecated
    @RequestMapping("/queryProvider")
    @ResponseBody
    public String getQueryProvider(HttpServletRequest req) throws SQLException{
        String id = req.getParameter("proid");


        Provider provider = null;
        try {
            provider = providerService.getQueryProvider(Integer.parseInt(id));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return JSON.toJSONString(provider);
    }
}
