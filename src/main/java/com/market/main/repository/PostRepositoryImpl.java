package com.market.main.repository;

import com.market.main.entity.posts.Post;
import com.market.main.entity.posts.QPost;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

import static com.market.main.entity.posts.QPost.post;

public class PostRepositoryImpl implements PostRepositoryCustom{

    @Autowired
    EntityManager em;

    @Override
    public Post findByIdCustom(Long id) {

        JPAQueryFactory query = new JPAQueryFactory(em);

        QPost post = QPost.post;

        return query.select(post)
                .from(post)
                .where(post.id.eq(id))
                .fetchOne();
    }
}
