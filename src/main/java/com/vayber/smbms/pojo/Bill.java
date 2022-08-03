package com.vayber.smbms.pojo;


import org.springframework.stereotype.Repository;

@Repository
public class Bill {
    private long id;
    private String billCode;
    private String productName; //商品名称
    private String productDesc; //商品描述
    private String productUnit; //商品单位
    private String productCount;
    private String totalPrice;
    private int isPayment;      //是否支付   1      2
    private String isPayments;  //是否支付   未支付  已支付
    private long createdBy;
    private String creationDate;
    private long modifyBy;
    private String modifyDate;
    private int providerId;
    private String proName; //供应商

    public Bill() {
    }

    public Bill(long id, String billCode, String productName, String productDesc, String productUnit, String productCount, String totalPrice, int isPayment, long createdBy, String creationDate, long modifyBy, String modifyDate, String proName, int providerId ,String isPayments) {
        this.id = id;
        this.billCode = billCode;
        this.productName = productName;
        this.productDesc = productDesc;
        this.productUnit = productUnit;
        this.productCount = productCount;
        this.totalPrice = totalPrice;
        this.isPayment = isPayment;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
        this.modifyBy = modifyBy;
        this.modifyDate = modifyDate;
        this.proName = proName;
        this.providerId = providerId;
        this.isPayments = isPayments;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBillCode() {
        return billCode;
    }

    public void setBillCode(String billCode) {
        this.billCode = billCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public String getProductUnit() {
        return productUnit;
    }

    public void setProductUnit(String productUnit) {
        this.productUnit = productUnit;
    }

    public String getProductCount() {
        return productCount;
    }

    public void setProductCount(String productCount) {
        this.productCount = productCount;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getIsPayment() {
        return isPayment;
    }

    public void setIsPayment(int isPayment) {
        this.isPayment = isPayment;
    }

    public String getIsPayments(){
        return isPayments;
    }
    public void setIsPayments(int isPayment){
        if (isPayment == 1){
            this.isPayments = "未支付";
        }else if (isPayment == 2){
            this.isPayments = "已支付";
        }
    }

    public long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(long createdBy) {
        this.createdBy = createdBy;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public long getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(long modifyBy) {
        this.modifyBy = modifyBy;
    }

    public String getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(String modifyDate) {
        this.modifyDate = modifyDate;
    }

    public  String getProName(){
        return proName;
    }

    public  void setProName(String proName){
        this.proName = proName;
    }


    public int getProviderId() {
        return providerId;
    }

    public void setProviderId(int providerId) {
        this.providerId = providerId;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", billCode='" + billCode + '\'' +
                ", productName='" + productName + '\'' +
                ", productDesc='" + productDesc + '\'' +
                ", productUnit='" + productUnit + '\'' +
                ", productCount='" + productCount + '\'' +
                ", totalPrice='" + totalPrice + '\'' +
                ", isPayment=" + isPayment +
                ", isPayments=" + isPayments +
                ", createdBy=" + createdBy +
                ", creationDate=" + creationDate +
                ", modifyBy=" + modifyBy +
                ", modifyDate=" + modifyDate +
                ", proName=" + proName +
                ", providerId=" + providerId +
                '}';
    }
}
