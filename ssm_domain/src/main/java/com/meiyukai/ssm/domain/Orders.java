package com.meiyukai.ssm.domain;

import com.meiyukai.ssm.DateUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
public class Orders implements Serializable {

    private String id;
    private String orderNum;    //订单号
    private Date orderTime;     //订单时间
    private String orderTimeStr;
    private Integer orderStatus;   //订单状态 0未支付 ； 1 已支付；
    private String orderStatusStr;
    private Integer peopleCount;   //出行人数
    private Product product;    //产品
    private List<Traveller> travellers;   // 旅客
    private Integer payType;   //支付状态  0：支付宝 ； 1：微信 ；2：其他
    private String payTypeStr;
    private String orderDesc;   //  订单描述
   private Member member;

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
        if(orderTime!=null){
            orderTimeStr = DateUtils.Date2Str(orderTime);
        }else{
            orderTimeStr=null;
        }
        return orderTimeStr;
    }

    public void setOrderTimeStr(String orderTimeStr) {
        this.orderTimeStr = orderTimeStr;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getPeopleCount() {
        return peopleCount;
    }

    public void setPeopleCount(Integer peopleCount) {
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
        if(payType==0){
            payTypeStr="支付宝支付";
        }
        if(payType==1){
            payTypeStr="微信支付";
        }
        if (payType==2){
            payTypeStr="其他支付方式";
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

    public String getOrderStatusStr() {
        if(orderStatus==0){
            orderStatusStr="未支付";
        }
        if (orderStatus==1){
            orderStatusStr="已支付";
        }
        return orderStatusStr;
    }

    public void setOrderStatusStr(String orderStatusStr) {
        this.orderStatusStr = orderStatusStr;
    }




    @Override
    public String toString() {
        return "Orders{" +
                "id='" + id + '\'' +
                ", orderNum='" + orderNum + '\'' +
                ", orderTime=" + orderTime +
                ", orderTimeStr='" + orderTimeStr + '\'' +
                ", orderStatus=" + orderStatus +
                ", orderStatusStr='" + orderStatusStr + '\'' +
                ", peopleCount=" + peopleCount +
                ", product=" + product +
                ", travellers=" + travellers +
                ", member=" + member +
                ", payType=" + payType +
                ", payTypeStr='" + payTypeStr + '\'' +
                ", orderDesc='" + orderDesc + '\'' +
                '}';
    }
}
