package com.meiyukai.ssm.dao;

import com.meiyukai.ssm.domain.Traveller;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository(value = "travellerDao")
public interface ITravellerDao {

    /**
     * 查询所有的 traveller
     */
    @Select("select * from traveller ")
    List<Traveller> findAll();

    /**
     * 根据id 查询 Traveller
     */
    @Select("select * from traveller where id = #{id}")
     Traveller findTravellerById(String id);

    /**
     * 根据 orderId 查询所有的 traveller
     * @return
     */
    @Select("select * from traveller where id in ( select travellerId from order_traveller where orderId = #{orderId})")
    List<Traveller> findTravellerByOrderId(String orderId);

}
