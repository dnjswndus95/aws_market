package com.market.main.service;

import com.market.main.entity.Post;
import com.market.main.entity.PostForm;
import com.market.main.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public Long registerPost(PostForm postForm){
        Post post = new Post(postForm);
        postRepository.save(post);
        return post.getId();
    }

    public List<Post> findAllPost(){
        return postRepository.findAll();
    }


}
