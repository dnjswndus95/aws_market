package com.market.main.entity.member;


import com.market.main.entity.Address;
import com.market.main.entity.BaseEntity;
import com.market.main.entity.Post;
import lombok.Getter;
import org.springframework.security.crypto.password.PasswordEncoder;

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

    private String password_confirm;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member")
    private List<Post> posts = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROLE_ID")
    private Role role;

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

    public Member(MemberForm memberForm){
        this.name = memberForm.getName();
        this.account = memberForm.getAccount();
        this.password = memberForm.getPassword();
        this.password_confirm = memberForm.getPassword_confirm();
        Address address = new Address(memberForm.getCity(), memberForm.getStreet(), memberForm.getZipcode());
        this.address = address;
    }



    /**
     *  비밀번호 확인
     */
    public void encodePassword(PasswordEncoder passwordEncoder){
        this.password = passwordEncoder.encode(this.password);
    }

}
