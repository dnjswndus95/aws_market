package com.market.main.entity.posts;

import com.market.main.entity.BaseEntity;
import com.market.main.entity.member.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 사용자가 물품 등록하는 게시글
 */

@Entity
@Getter
@NoArgsConstructor
public class Post extends BaseEntity {

    @Id @GeneratedValue
    private Long id;

    private String title;

   // @Column(columnDefinition = "TEXT") // 타입을 TEXT로 변경경
    private String content;

    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;*/

    private String author;

   /* @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Item item;*/

    public Post(PostRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
    }

    @Builder
    public Post(String title, String content){
        this.title = title;
        this.content = content;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }

    /**
     * Member Parameter로 생성하는 생성자는
     * 로그인 완료된 이후에 가능할듯
     */
}
