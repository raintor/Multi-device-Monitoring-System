package com.nuaa.back_ma.domain;

/**
 * @author: raintor
 * @Date: 2019/5/28 15:22
 * @Description:
 */

import com.nuaa.back_ma.utils.DateStringUtil;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 订单的实体类
 */
public class Orders implements Serializable {
    private String id;
    private String orderNum;
    private Date orderTime;
    private String orderTimeStr;

    private int orderStatus;
    private String orderStatusStr;

    private int peopleCount;

    //这里业务决定了一个订单只有一个产品
    private Product product;
    private List<Traveller> travellers;
    private Member member;

    private Integer payType;
    private String payTypeStr;

    private String orderDesc;

    public String getOrderStatusStr() {
//        订单状态(0 未支付 1 已支付)
        if(orderStatus==1){
            orderStatusStr="已支付";

        }else {
            orderStatusStr="未支付";
        }
        return orderStatusStr;
    }

    public void setOrderStatusStr(String orderStatusStr) {
        this.orderStatusStr = orderStatusStr;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderTimeStr() {
        orderTimeStr = DateStringUtil.Date2String(orderTime, "yyyy-MM-dd HH:mm");
        return orderTimeStr;
    }

    public void setOrderTimeStr(String orderTimeStr) {
        this.orderTimeStr = orderTimeStr;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(int peopleCount) {
        this.peopleCount = peopleCount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Traveller> getTravellers() {
        return travellers;
    }

    public void setTravellers(List<Traveller> travellers) {
        this.travellers = travellers;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getPayTypeStr() {
//        支付方式(0 支付宝 1 微信 2其它)
        switch (payType){
            case 0:
                payTypeStr="支付宝";
                break;
            case 1:
                payTypeStr="微信";
                break;
            case 2:
                payTypeStr="其他";
                break;
        }
        return payTypeStr;
    }

    public void setPayTypeStr(String payTypeStr) {
        this.payTypeStr = payTypeStr;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }
}
