package com.meiyukai.controller;

import com.meiyukai.ssm.domain.PageInfo;
import com.meiyukai.ssm.domain.SysLog;
import com.meiyukai.ssm.service.ISysLogService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/sysLog")
public class sysLogController {

    @Resource(name = "sysLogService")
    private ISysLogService sysLogService;

    @RequestMapping(value = "/findAll.do")
    @PreAuthorize(value = "hasRole('ROLE_ADMIN')")
    public String findAllSysLogs(ModelMap model ,
                             @RequestParam(value = "pageNum", required = true, defaultValue = "1") Integer pageNum ,
                             @RequestParam(value = "pageSize" , required = true , defaultValue = "10") Integer pageSize,
                                 @RequestParam(value = "username", required = true , defaultValue ="") String username){
        PageInfo<SysLog> sysLogs   =  sysLogService.findAllSysLogs(pageNum , pageSize , username);
        model.addAttribute("sysLogs"  , sysLogs);
        return "sysLog-list";
    }







}
