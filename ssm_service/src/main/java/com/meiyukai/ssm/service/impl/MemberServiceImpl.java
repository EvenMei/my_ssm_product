package com.meiyukai.ssm.service.impl;

import com.meiyukai.ssm.dao.IMemeberDao;
import com.meiyukai.ssm.domain.Member;
import com.meiyukai.ssm.service.IMemberService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service(value = "memeverService")
@Transactional
public class MemberServiceImpl implements IMemberService {
    @Resource(name = "memberDao")
    private IMemeberDao memberDao;

    @Override
    public Member findMemberById(String memberId) {
        return memberDao.findMemberById(memberId);
    }
}
