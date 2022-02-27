package com.market.main.repository;

import com.market.main.entity.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom {

}
