package com.meiyukai.ssm.service;

import com.meiyukai.ssm.domain.Member;

public interface IMemberService {
    /**
     * 根据id 查询 Memeber
     */
    Member findMemberById(String memberId);

}
