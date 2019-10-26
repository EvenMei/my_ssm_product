package com.meiyukai.ssm.dao;


import com.meiyukai.ssm.domain.Orders;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 订单操作的持久层
 */
@Repository(value = "orderDao")
public interface IOrderDao {
    /**
     * 查询所有
     */


    @Results(id="orders_map",value = {

            @Result( id=true ,  property = "id" ,column = "id"),
            @Result(property = "orderNum" , column = "orderNum"),
            @Result(property = "orderTime" , column = "orderTime"),
            @Result(property = "orderStatus" , column = "orderStatus"),
            @Result(property = "peopleCount" , column = "peopleCount"),
            @Result(property = "member" , column = "memberId",
                    one = @One(select = "com.meiyukai.ssm.dao.IMemeberDao.findMemberById", fetchType = FetchType.EAGER)),
            @Result(property = "payType" , column = "payType"),
            @Result(property = "orderDesc" , column = "orderDesc"),
            @Result(property = "product" , column = "productId" ,
                    one = @One(select = "com.meiyukai.ssm.dao.IProductDao.findProductById" , fetchType = FetchType.EAGER)
            ),
            @Result(property = "travellers" , column = "id" ,
                    many = @Many(select = "com.meiyukai.ssm.dao.ITravellerDao.findTravellerByOrderId",fetchType = FetchType.LAZY))

    })

    @Select("select * from orders")
    List<Orders> findAll();


    /**
     *根据  travellerId查询orders
     */

    @Select(value="select * from orders where id in (select * from order_traveller where travellerId = #{travellerId})")
    List<Orders> findOrdersByTravellerId(String travellerId);


    /**
     * 根据 orderId 查询 order
     */
    @Results(id ="order_traveller_map" , value = {
            @Result(id = true , property = "id" , column = "id"),
            @Result(property = "travellers" ,column = "id",
                    many = @Many(select = "com.meiyukai.ssm.dao.ITravellerDao.findTravellerByOrderId" , fetchType = FetchType.LAZY)),
            @Result(property = "member", column = "memberId" ,
                    one = @One(select = "com.meiyukai.ssm.dao.IMemeberDao.findMemberById",fetchType = FetchType.EAGER)),
            @Result(property = "product" ,column = "productId" ,
                    one = @One(select = "com.meiyukai.ssm.dao.IProductDao.findProductById", fetchType = FetchType.EAGER))
    })
    @Select("select * from orders where id=#{id}")
    Orders findOrdersById(String orderId);




}
