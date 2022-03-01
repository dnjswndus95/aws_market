package com.market.main.service;

import com.market.main.entity.member.Member;
import com.market.main.entity.member.MemberForm;
import com.market.main.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {

    @Autowired
    MemberRepository memberRepository;

    private PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
        Member member = memberRepository.findByAccount(account);

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("role_user"));
        return new User(member.getAccount(), member.getPassword(), grantedAuthorities);
    }

    @Transactional
    public Long join(Member member){
        validateDuplicateAccountName(member.getAccount());
        memberRepository.save(member);
        return member.getId();
    }


    @Transactional
    public Member save(MemberForm memberForm){
        Member member = new Member(memberForm);
   //     member.encodePassword(passwordEncoder);
        return memberRepository.save(member);
    }

    public List<Member> findAllMember(){
        return memberRepository.findAll();
    }



    /**
     * 중복아이디 검사
     */
    public void validateDuplicateAccountName(String account){
        System.out.println("account = " + account);
        Member findMember = memberRepository.findByAccount(account);
        if(findMember != null)
            throw new IllegalStateException("중복된 아이디입니다.");
    }


}
