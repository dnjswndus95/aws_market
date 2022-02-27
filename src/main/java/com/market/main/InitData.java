package com.market.main;

import com.market.main.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

@Component
@RequiredArgsConstructor
public class InitData {

    private final InitService initService;

    @PostConstruct
    public void Init(){
        initService.InitDB();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService{
        private final EntityManager em;

        public void InitDB(){
            Member member1 = new Member("원주연", "dnjswndus95");
            Member member2 = new Member("최진호", "chlwlsgh94");

            em.persist(member1);
            em.persist(member2);
        }
    }
}
