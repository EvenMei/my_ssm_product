package com.meiyukai.ssm.service;

import com.meiyukai.ssm.domain.Traveller;

import java.util.List;

public interface ITravellerService {
    /**
     * 查询所有的 traveller
     */
    List<Traveller> findAll();


    /**
     * 根据id 查询 Traveller
     */
    Traveller findTravellerById(String id);


    /**
     * 根据 orderId 查询所有的 traveller
     * @return
     */
    List<Traveller> findTravellerByOrderId(String orderId);


}
