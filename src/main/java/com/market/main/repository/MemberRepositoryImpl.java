package com.market.main.repository;

import com.market.main.entity.member.Member;
import com.market.main.entity.member.QMember;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;

import static com.market.main.entity.member.QMember.member;

public class MemberRepositoryImpl implements MemberRepositoryCustom{

    @Autowired
    EntityManager em;

    @Override
    public Member findByAccount(String account) {

        JPAQueryFactory query = new JPAQueryFactory(em);

        QMember member = QMember.member;

        return query.select(member)
                .from(member)
                .where(accountLike(account))
                .fetchOne();
    }

    private BooleanExpression accountLike(String account) {
        if(!StringUtils.hasText(account))
            return null;

        return member.account.like(account);
    }
}
