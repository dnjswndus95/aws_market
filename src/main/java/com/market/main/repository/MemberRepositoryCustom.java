package com.market.main.repository;


import com.market.main.entity.Member;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface MemberRepositoryCustom {

    public Member findByAccount(String account);
}
