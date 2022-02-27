package com.market.main.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Item {

    @Id @GeneratedValue
    @Column(name = "ITEM_ID")
    private Long id;

    private String name;
    private int price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

    @OneToOne(mappedBy = "item", cascade = CascadeType.ALL)
    private Post post;


}
