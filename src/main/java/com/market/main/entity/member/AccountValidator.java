package com.market.main.entity.member;

import com.market.main.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class AccountValidator implements Validator {

    @Autowired
    MemberRepository memberRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return MemberForm.class.equals(clazz);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        MemberForm MemberForm = (MemberForm) obj;
      /*  if(!((MemberForm) obj).getPassword().equals(((MemberForm) obj).getPassword_confirm()))
            errors.rejectValue("password", "key", "비밀번호가 일치하지 않습니다.");
*/
        if(memberRepository.findByAccount(((MemberForm) obj).getAccount()) != null)
            errors.rejectValue("account", "key", "이미 존재하는 ID입니다.");
    }
}
