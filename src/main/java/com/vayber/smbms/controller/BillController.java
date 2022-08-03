package com.vayber.smbms.controller;

import com.alibaba.fastjson.JSON;
import com.vayber.smbms.pojo.Bill;
import com.vayber.smbms.service.bill.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/billManagement.do")
public class BillController {

    @Autowired
    private BillService billService;

    @RequestMapping("/queryList")
    @ResponseBody
    public String queryList(HttpServletRequest req) throws  SQLException {
        //从前端获取数据
        String queryProductName = req.getParameter("queryProductName"); //查询商品
        String queryProvider = req.getParameter("queryProvider");       //查询供应商
        String queryIsPayment = req.getParameter("queryIsPayment");     //查询是否付款



        int queryProviderId = 0;
        int queryIsPaymentNum = 0;


        List<Bill> billList = null;


        if (queryProductName == null){  //给查询赋值
            queryProductName = "";
        }
        //     下拉框不选择默认是null 如果选了就走下面if 赋选择的值
        if (queryProvider != null && !queryProvider.equals("")){
            queryProviderId = Integer.parseInt(queryProvider);
        }
        if (queryIsPayment != null && !queryIsPayment.equals("")){
            queryIsPaymentNum = Integer.parseInt(queryIsPayment);
        }


        //获取账单列表展示
        billList = billService.getBillList(queryProductName, queryProviderId, queryIsPaymentNum);



      return JSON.toJSONString(billList);

    }

    @RequestMapping("/getBillCount")
    @ResponseBody
    public String getBillCount(HttpServletRequest req) throws SQLException {
        //从前端获取数据
        String queryProductName = req.getParameter("queryProductName"); //查询商品
        String queryProvider = req.getParameter("queryProvider");       //查询供应商
        String queryIsPayment = req.getParameter("queryIsPayment");     //查询是否付款


        int queryProviderId = 0;
        int queryIsPaymentNum = 0;

        if (queryProductName == null){  //给查询赋值
            queryProductName = "";
        }
        //   int queryProviderId = 0  下拉框不选择默认是0 如果选了就走下面if 赋选择的值
        if (queryProvider != null && !queryProvider.equals("")){
            queryProviderId = Integer.parseInt(queryProvider);
        }
        if (queryIsPayment != null && !queryIsPayment.equals("")){
            queryIsPaymentNum = Integer.parseInt(queryIsPayment);
        }




        int billCount = billService.getBillCount(queryProductName, queryProviderId, queryIsPaymentNum);

        return JSON.toJSONString(billCount);
    }

    @RequestMapping("/add")
    @ResponseBody
    public String addBill(HttpServletRequest req) throws  SQLException {

        String createdBy = req.getParameter("createdBy");
        String billCode = req.getParameter("billCode");
        String productName = req.getParameter("productName");
        String productDesc = req.getParameter("productDesc");
        String productUnit = req.getParameter("productUnit");
        String productCount = req.getParameter("productCount");
        String totalPrice = req.getParameter("totalPrice");
        String providerId = req.getParameter("providerId");
        String isPayment = req.getParameter("isPayment");


        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String creationDate = simpleDateFormat.format(date);

        Bill bill = new Bill();
        bill.setBillCode(billCode);
        bill.setProductName(productName);
        bill.setProductDesc(productDesc);
        bill.setProductUnit(productUnit);
        bill.setProductCount(productCount);
        bill.setTotalPrice(totalPrice);
        bill.setProviderId(Integer.parseInt(providerId));
        bill.setIsPayment(Integer.parseInt(isPayment));
        bill.setCreationDate(creationDate);
        bill.setCreatedBy(Long.parseLong(createdBy));


        int b = billService.addBill(bill);
        String result = "";
        if (b == 1){
            result = "add success";
        }else {
            result = "add failure";
        }


        return JSON.toJSONString(result);

    }
    @RequestMapping("/delete")
    @ResponseBody
    public String deleteBill(HttpServletRequest req) throws  SQLException {
        String billId = req.getParameter("billid");



        int b = billService.deleteBill(Integer.parseInt(billId));

        String result = "";

        if (b == 1 ){
            result = "delete success!";
        }else {

            result = "delete failure!";
        }

      return JSON.toJSONString(result);
    }


    @RequestMapping("/modify")
    @ResponseBody
    public String modify(HttpServletRequest req) throws ServletException, IOException, SQLException {

        String id = req.getParameter("id");
        String billCode = req.getParameter("billCode");
        String productName = req.getParameter("productName");
        String productDesc = req.getParameter("productDesc");
        String productUnit = req.getParameter("productUnit");
        String productCount = req.getParameter("productCount");
        String totalPrice = req.getParameter("totalPrice");
        String providerId = req.getParameter("providerId");
        String isPayment = req.getParameter("isPayment");
        String modifyBy = req.getParameter("modifyBy");

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String modifyDate = simpleDateFormat.format(date);

        Bill bill = new Bill();
        bill.setId(Long.parseLong(id));
        bill.setBillCode(billCode);
        bill.setProductName(productName);
        bill.setProductDesc(productDesc);
        bill.setProductUnit(productUnit);
        bill.setProductCount(productCount);
        bill.setTotalPrice(totalPrice);
        bill.setProviderId(Integer.parseInt(providerId));
        bill.setIsPayment(Integer.parseInt(isPayment));
        bill.setModifyBy(Long.parseLong(modifyBy));
        bill.setModifyDate(modifyDate);


        int i = billService.modifyBill(bill);

        String result = "";

        if (i == 1 ){
            result = "delete success!";
        }else {

            result = "delete failure!";
        }

        return JSON.toJSONString(result);

    }




}
