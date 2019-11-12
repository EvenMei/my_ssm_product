package com.meiyukai.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.meiyukai.ssm.dao.ISysLogDao;
import com.meiyukai.ssm.domain.PageInfo;
import com.meiyukai.ssm.domain.SysLog;
import com.meiyukai.ssm.service.ISysLogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
@Service(value = "sysLogService")
@Transactional
public class SyslogService implements ISysLogService {
    @Resource(name = "sysLogDao")
    private ISysLogDao sysLogDao;

    @Override
    public List<SysLog> findAll(String username) {
        return sysLogDao.findAll(username);
    }

    @Override
    public void saveSysLog(SysLog sysLog) {
        sysLogDao.saveSysLog(sysLog);
    }

    /**
     * 查找所有的SysLog 进行分页显示
     */
    public PageInfo<SysLog> findAllSysLogs(Integer currentPage , Integer pageSize , String username){
        Double totalCount = sysLogDao.findSysLogCount();
        PageInfo<SysLog> pageInfo = new PageInfo<>();
        pageInfo.setTotalCount(totalCount.intValue());  //设置 总记录数
        Double totalPages = Math.ceil(totalCount/pageSize);
        pageInfo.setTotalPages(totalPages.intValue()); //设置总页数
        pageInfo.setPageSize(pageSize);
        pageInfo.setPageNum(currentPage);
        PageHelper.startPage(currentPage , pageSize);
        List<SysLog> sysLogs = sysLogDao.findAll(username);
        System.out.println("afterPageHelper size  is   : "  + sysLogs.size()  );
        pageInfo.setList(sysLogs);
        return pageInfo;

    }


}
