package com.market.main.service;

import com.market.main.entity.posts.Post;
import com.market.main.entity.posts.PostRequestDto;
import com.market.main.entity.posts.PostResponseDto;
import com.market.main.entity.posts.PostUpdateDto;
import com.market.main.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public Long registerPost(PostRequestDto requestDto){
        Post post = Post.builder().title(requestDto.getTitle())
                        .content(requestDto.getContent())
                                .build();

        postRepository.save(post);
        return post.getId();
    }

    public List<Post> findAllPost(){
        return postRepository.findAll();
    }

    @Transactional
    public Long update(Long id, PostUpdateDto updateDto) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다."));

        post.update(updateDto.getTitle(), updateDto.getContent());

        return id;
    }




}
