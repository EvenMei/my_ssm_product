package com.meiyukai.controller;

import com.meiyukai.ssm.domain.Orders;
import com.meiyukai.ssm.service.IOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping(value = "/orders")
public class orderController {

    @Resource(name = "orderService")
    private IOrderService service;

    /**
     * 查询所有的订单
     * @return
     */
    @RequestMapping(value = "/findAll.do")
    public String findAllOrders(ModelMap model){
        List<Orders> orders = service.findAll();
        model.addAttribute("orders" , orders);
        return "orders-list";
    }

    @RequestMapping(value = "/showDetail.do")
    public String showDetail(@RequestParam(value = "id") String id , ModelMap model){
        System.out.println("id :  ---   " + id);
        Orders order  = service.findOrdersById(id);
        model.addAttribute("order"  , order);
        return "order-detail";
    }




}
