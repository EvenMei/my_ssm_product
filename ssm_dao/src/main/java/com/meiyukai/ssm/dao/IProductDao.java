package com.meiyukai.ssm.dao;

import com.meiyukai.ssm.domain.Product;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *  product 持久化操作
 */
@Repository(value = "productDao")
public interface IProductDao {


    /**
     * 查询所有的  product
     * @return
     */
    @Select("select * from product ")
    List<Product>findAll();

    /**
     * 保存上商品信息
     */
    @Insert(" insert into product values( #{id},#{productNum}, #{productName},#{cityName},#{departureTime} ,#{productPrice}, #{productDesc} , #{productStatus}) " )
    void save(Product product);


    /**
     * 根据ID删除订单
     */
    @Delete("delete from product where id  =#{id}")
    void delete(String id);

    /**
     * 根据 productId 查询product
     */
    @Select("select * from product where id = #{id}")
    Product findProductById(String id);

    /**
     * 查询product 的总记录数
     */
    @Select("select count(1) from product ")
    Double getTotalCount();

}
