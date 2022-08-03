package com.vayber.smbms.dao.Bill;



import com.vayber.smbms.pojo.Bill;
import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
import java.util.List;


public interface BillMapper {
    //获取商品数量(根据商品名或者供应商或者是否付款)
    public  int getBillCount(@Param("productName") String productName, @Param("providerId")int providerId, @Param("isPayment")int isPayment) throws SQLException;

    //通过条件查询获取账单列表 搜索框
    public List<Bill> getBillList( @Param("productName")String productName, @Param("providerId")int providerId, @Param("isPayment")int isPayment) throws  SQLException;

    //添加订单
    public int addBill( Bill bill) throws  SQLException;

    //删除订单
    public int deleteBill( int id) throws  SQLException;

    //修改订单
    public int modifyBill( Bill bill) throws SQLException;

}
