package com.market.main.service;

import com.market.main.entity.Member;
import com.market.main.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class MemberService {

    @Autowired
    MemberRepository memberRepository;

    @Transactional
    public Long join(Member member){
        validateDuplicateAccountName(member.getAccount());
        memberRepository.save(member);
        return member.getId();
    }

    public List<Member> findAllMember(){
        return memberRepository.findAll();
    }



    /**
     * 중복아이디 검사
     */
    public void validateDuplicateAccountName(String account){
        Member findMember = memberRepository.findByAccount(account);
        if(findMember != null)
            throw new IllegalStateException("중복된 아이디입니다.");
    }


}
