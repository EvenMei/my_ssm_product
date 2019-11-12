package com.meiyukai.ssm.service;

import com.meiyukai.ssm.domain.PageInfo;
import com.meiyukai.ssm.domain.SysLog;

import java.util.List;

public interface ISysLogService {

    /**
     * 查询所有
     */
    List<SysLog> findAll(String username);

    /**
     * 保存SysLOg
     */
    void saveSysLog(SysLog sysLog);

    /**
     * 查找所有的SysLog 进行分页显示
     */
    PageInfo<SysLog> findAllSysLogs(Integer currentPage , Integer pageSize ,String username);





}
