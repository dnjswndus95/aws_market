package com.market.main.config.auth.dto;

import com.market.main.entity.member.Member;
import lombok.Getter;

import java.io.Serializable;

/**
 * Member를 그대로 넣게 되면 오류가 발생
 * Member는 Entity이며 다른 엔티티와 수 많은 연관관계를 가지고 있기 때문에 세션에 그대로 사용하기엔 성능 이슈와 다른 문제가 발생할 여지가 많다.
 * 따라서 Web계층에서 Dto를 사용하는 것처럼 Session용 Dto를 만드는 것이 좋다.
 */

@Getter
public class MemberSession implements Serializable {

    private String name;
    private String email;
    private String picture;

    public MemberSession(Member member){
        this.name = member.getName();
        this.email = member.getEmail();
        this.picture = member.getPicture();
    }
}
