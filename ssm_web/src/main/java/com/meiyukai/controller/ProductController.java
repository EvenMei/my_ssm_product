package com.meiyukai.controller;

import com.meiyukai.ssm.domain.PageInfo;
import com.meiyukai.ssm.domain.Product;
import com.meiyukai.ssm.service.IProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(value = "/product")
public class ProductController {

    @Resource(name = "productService")
    private IProductService service;


    /**
     *   查询所有的商品
     */

    /*@RequestMapping(value = "/findAll.do")
    public ModelAndView findAll(){
         ModelAndView mav = new ModelAndView();
         List<Product> products = service.findAll();
         mav.addObject("products",products);
         mav.setViewName("product_list");
         return mav;
    }*/

    @RequestMapping(value = "/findProducts.do")
    public String findAll(Model model , @RequestParam(value = "pageNum") Integer pageNum, @RequestParam(value = "pageSize") Integer pageSize){
        System.out.println("pageNum  :  " + pageNum + "-----"  + "pageSize  :  " + pageSize) ;
        PageInfo<Product> pageInfo = service.getPageInfo(pageNum,pageSize);
        System.out.println("----  pageInfo  ---   " + pageInfo);
        model.addAttribute("pageInfo",pageInfo);

      return "product-list";
    }


    @RequestMapping(value = "/findAll.do")
    @ResponseBody
    public String findAll(Model model , @RequestBody String info ){
        System.out.println("requestBody   :  " + info);
        //System.out.println("pageNum  :  " + pageNum + "-----"  + "pageSize  :  " + pageSize) ;
       // PageInfo<Product> pageInfo = service.getPageInfo(pageNum,pageSize);
       // System.out.println("----  pageInfo  ---   " + pageInfo);
       // model.addAttribute("pageInfo",pageInfo);
        return "success";
    }



    /**
     * 保存商品
     * @return
     */
    @RequestMapping(value = "/save.do")
    public String  save(Product product){
//        System.out.println("从前端传来的product 是： " + product);
        product.setId(UUID.randomUUID().toString().substring(0,16)); //给主键赋值。
        service.save(product);
        return "forward:findAll.do?pageNum=1&pageSize=4";
    }




    @RequestMapping(value = "/delete.do", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String deleteByNum(@RequestBody List<String> selectList , HttpServletRequest request, HttpServletResponse response)throws Exception{

        String msg = "删除失败！";

        //从List中遍历字符串完成删除操作
        for (String productId :selectList) {
            System.out.println( productId );
            service.delete(productId);
            msg = "删除成功！";
        }

        return  msg ;
    }





    @RequestMapping(value = "main.do")
    public String test(){
        return "main";
    }


}
