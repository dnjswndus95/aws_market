package com.market.main.repository;


import com.market.main.entity.member.Member;

public interface MemberRepositoryCustom {

    public Member findByAccount(String account);
}
