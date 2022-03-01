package com.market.main.entity.member;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberForm {
    private String name;
    private String account;
    private String password;
    private String password_confirm;

    private String city;
    private String street;
    private String zipcode;


}
