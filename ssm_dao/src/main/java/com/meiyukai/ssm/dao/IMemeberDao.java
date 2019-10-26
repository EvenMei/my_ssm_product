package com.meiyukai.ssm.dao;

import com.meiyukai.ssm.domain.Member;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository(value = "memberDao")
public interface IMemeberDao {
    /**
     * 根据id 查询 Memeber
     */

    @Select("select * from member where id = #{id}")
    Member findMemberById(String memberId);
}
