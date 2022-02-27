package com.market.main.entity;

import com.market.main.entity.member.Member;
import lombok.Getter;

import javax.persistence.*;

/**
 * 사용자가 물품 등록하는 게시글
 */

@Entity
@Getter
public class Post extends BaseEntity{

    @Id @GeneratedValue
    private Long id;

    private String title;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Item item;

}
