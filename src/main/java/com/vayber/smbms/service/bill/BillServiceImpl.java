package com.vayber.smbms.service.bill;

import com.vayber.smbms.dao.Bill.BillMapper;
import com.vayber.smbms.pojo.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;


@Service
public class BillServiceImpl implements BillService{

    @Autowired
    private BillMapper billMapper;

    public int getBillCount(String billName, int providerId, int isPayment) throws SQLException {
        return billMapper.getBillCount(billName,providerId,isPayment);
    }

    public List<Bill> getBillList(String billName, int providerId, int isPayment) throws SQLException {
        return billMapper.getBillList(billName,providerId,isPayment);
    }

    public int addBill(Bill bill) throws SQLException {
        return billMapper.addBill(bill);
    }

    public int deleteBill(int id) throws SQLException {
        return billMapper.deleteBill(id);
    }

    public int modifyBill(Bill bill) throws SQLException {
        return billMapper.modifyBill(bill);
    }
}
