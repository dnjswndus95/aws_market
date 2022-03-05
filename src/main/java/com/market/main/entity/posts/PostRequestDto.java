package com.market.main.entity.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostRequestDto {

    private String title;
    private String content;
    private String author;


    @Builder
    public PostRequestDto(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Post toEntity(){
        return Post.builder()
                .title(title)
                .content(content)
                .build();
    }

}
