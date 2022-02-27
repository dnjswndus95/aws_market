package com.market.main.repository;

import com.market.main.entity.Member;
import com.market.main.entity.QMember;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;

import java.util.Optional;

import static com.market.main.entity.QMember.member;

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
