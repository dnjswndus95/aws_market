package com.market.main.repository;

import com.market.main.entity.posts.Post;

public interface PostRepositoryCustom {

    public Post findByIdCustom(Long id);
}
