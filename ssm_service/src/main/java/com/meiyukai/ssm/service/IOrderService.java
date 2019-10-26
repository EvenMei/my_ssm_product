package com.meiyukai.ssm.service;

import com.meiyukai.ssm.domain.Orders;

import java.util.List;

public interface IOrderService {
    /**
     * 根据ID查询所有 Order
     * @return
     */
    List<Orders> findAll();

    /**
     *根据  travellerId查询orders
     */
    List<Orders> findOrdersByTravellerId(String travellerId);

    /**
     * 根据 orderId 查询 order
     */
    Orders findOrdersById(String orderId);


}
