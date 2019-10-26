package com.meiyukai.ssm.domain;

import com.meiyukai.ssm.DateUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * 产品信息
 */

public class Product implements Serializable {
    private String id;  //主键
    private  String productNum; //产品编号
    private String productName; //产品名称
    private String cityName;  //城市名称
//  @DateTimeFormat(pattern = "MM-dd-yyyy HH:mm")
    private Date departureTime; //出发时间
    private String departureTimeStr;
    private Double productPrice;   //产品价格
    private String productDesc;   //产品描述
    private Integer productStatus;   //产品状态
    private String productStatusStr;  //0 关闭 ；1开启

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public String getDepartureTimeStr() {
        if(departureTime!=null){
            departureTimeStr= DateUtils.Date2Str(departureTime);
        }
        return departureTimeStr;
    }

    public void setDepartureTimeStr(String departureTimeStr) {
        this.departureTimeStr = departureTimeStr;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public String getProductStatusStr() {
        if(productStatus!=null){
            //0 关闭 ； 1 开启
            if(productStatus==0){
                productStatusStr="关闭";
            }
            if(productStatus==1){
                productStatusStr="开启" ;
            }
        }
        return productStatusStr;
    }

    public void setProductStatusStr(String productStatusStr) {
        this.productStatusStr = productStatusStr;
    }


    @Override
    public String  toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", productNum='" + productNum + '\'' +
                ", productName='" + productName + '\'' +
                ", cityName='" + cityName + '\'' +
                ", departureTime=" + departureTime +
                ", departureTimeStr='" + departureTimeStr + '\'' +
                ", productPrice=" + productPrice +
                ", productDesc='" + productDesc + '\'' +
                ", productStatus=" + productStatus +
                ", productStatusStr='" + productStatusStr + '\'' +
                '}';
    }
}
