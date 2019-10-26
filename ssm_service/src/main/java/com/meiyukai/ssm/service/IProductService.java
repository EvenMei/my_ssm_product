package com.meiyukai.ssm.service;

import com.meiyukai.ssm.domain.PageInfo;
import com.meiyukai.ssm.domain.Product;

import java.util.List;

public interface IProductService {

    /**
     * 查询所有的  product
     * @return
     */

    List<Product> findAll();

    /**
     * 保存商品信息
     */
    void save(Product product);

    /**
     * 删除 product
     */
    void delete(String id);


    /**
     * 获取每页的详细内容包括 分页的信息
     */

    PageInfo<Product> getPageInfo(Integer pageNum , Integer pageSize);


    /**
     * 查询product 的总记录数
     */
    Double getTotalCount();


}
