package com.market.main.service;

import com.market.main.entity.Member;
import com.market.main.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AssertionsKt;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    MemberService memberService;

    @Test
    public void joinTest(){
        Member member = new Member("원주연", "dnjswndus95");
        Long joinId = memberService.join(member);

        Optional<Member> findMember = memberRepository.findById(joinId);
        Member savedMember = findMember.orElse(null);

        assertThat(member.getId()).isEqualTo(savedMember.getId());

        // 중복아이디 가입 방지 테스트
        Member member2 = new Member("원성연", "dnjswndus95");
        memberService.join(member2);
    }

    @Test
    public void findAllTest(){
        Member member1 = new Member("xx", "xxx");
        Member member2 = new Member("xx", "yyy");

        memberService.join(member1);
        memberService.join(member2);

        List<Member> allMember = memberService.findAllMember();
        assertThat(allMember).size().isEqualTo(2);
    }

}