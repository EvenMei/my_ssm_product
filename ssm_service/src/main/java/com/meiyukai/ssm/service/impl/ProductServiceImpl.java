package com.meiyukai.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.meiyukai.ssm.dao.IProductDao;
import com.meiyukai.ssm.domain.PageInfo;
import com.meiyukai.ssm.domain.Product;
import com.meiyukai.ssm.service.IProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service(value = "productService")
@Transactional
public class ProductServiceImpl implements IProductService {

    @Resource(name = "productDao")
    private IProductDao productDao;

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public void save(Product product) {
        productDao.save(product);
    }

    @Override
    public void delete(String id) {
        productDao.delete(id);
    }


    @Override
    public Double getTotalCount() {
        return productDao.getTotalCount();
    }



    @Override
    public PageInfo<Product> getPageInfo(Integer pageNum, Integer pageSize) {
        Double totalCount = getTotalCount();
        PageInfo<Product> pageInfo   =  new PageInfo<>();
        PageHelper.startPage(pageNum,pageSize);
        List<Product>products = productDao.findAll();
        pageInfo.setTotalCount(totalCount.intValue()); //设置总记录数
        pageInfo.setList(products);  //设置表格数据
        pageInfo.setPageNum(pageNum); //设置当前页
        pageInfo.setPageSize(pageSize);  //设置每页显示的记录数
         double ceil = totalCount/pageSize;
        Double totalPages = Math.ceil(ceil);
        pageInfo.setTotalPages(totalPages.intValue());  //设置总页数
        return pageInfo;
    }



}
