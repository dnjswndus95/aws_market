package com.market.main.entity.member;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Role {

    @Id @GeneratedValue
    @Column(name = "ROLE_ID")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "role")
    private List<Member> members = new ArrayList<>();
}
