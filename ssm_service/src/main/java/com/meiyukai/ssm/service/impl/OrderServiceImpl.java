package com.meiyukai.ssm.service.impl;

import com.meiyukai.ssm.dao.IOrderDao;
import com.meiyukai.ssm.domain.Orders;
import com.meiyukai.ssm.service.IOrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "orderService")
@Transactional
public class OrderServiceImpl implements IOrderService {
    @Resource(name = "orderDao")
    private IOrderDao orderDao;

    @Override
    public List<Orders> findAll() {
        return orderDao.findAll();
    }

    @Override
    public List<Orders> findOrdersByTravellerId(String travellerId) {
        return orderDao.findOrdersByTravellerId(travellerId);
    }

    @Override
    public Orders findOrdersById(String orderId) {
        return orderDao.findOrdersById(orderId);
    }

}
