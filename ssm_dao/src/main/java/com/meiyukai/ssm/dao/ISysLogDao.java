package com.meiyukai.ssm.dao;

import com.meiyukai.ssm.SqlProvider.SysLogProvider;
import com.meiyukai.ssm.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "sysLogDao")
public interface ISysLogDao {
    /**
     * 查询所有
     */
    //@Select(value = "select * from sysLog")
    @SelectProvider(type = SysLogProvider.class , method = "insertProvider")
    List<SysLog> findAll(@Param(value="username") String username );

    /**
     * 保存SysLOg
     */
    @Insert(value = "insert into sysLog values(#{id} , #{visitTime} , #{username} , #{ip} , #{url} ,#{executionTime},#{method})")
    void saveSysLog(SysLog sysLog);

    /**
     * 查找记录总数
     */
    @Select(value="select count(1) from sysLog ")
    Double findSysLogCount();

}
