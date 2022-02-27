package com.market.main.entity.member;


import com.market.main.entity.Address;
import com.market.main.entity.BaseEntity;
import com.market.main.entity.Post;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Member extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    private String name;

    private String account;
    private String password;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member")
    private List<Post> posts = new ArrayList<>();

    protected Member(){}

    public Member(String name, String account){
        this.name = name;
        this.account = account;
    }

    public Member(String name, String account, String password, Address address){
        this.name = name;
        this.account = account;
        this.password = password;
        this.address = address;
    }

}
