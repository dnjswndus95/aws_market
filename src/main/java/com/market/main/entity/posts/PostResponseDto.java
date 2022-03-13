package com.market.main.entity.posts;

import lombok.Getter;

@Getter
public class PostResponseDto {

    private Long id;
    private String title;
    private String content;    private String author;

    public PostResponseDto(Post post){
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.author = post.getMember().getName();
    }
}
