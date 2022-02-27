package com.market.main.controller;

import com.market.main.entity.Address;
import com.market.main.entity.member.Member;
import com.market.main.entity.member.MemberForm;
import com.market.main.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    /*@GetMapping("/members")
    public List<Member> findMembers(){
        return memberService.findAllMember();
    }*/

    @GetMapping("/members/new")
    public String createMemberForm(Model model){
        model.addAttribute("memberForm", new MemberForm());
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String createMember(MemberForm form, BindingResult result){
        if(result.hasErrors())
            return "members/createMemberForm";

        Address address = new Address(form.getCity(), form.getStreet(), form.getZipcode());
        Member member = new Member(form.getName(), form.getAccount(), form.getPassword(), address);

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String members(Model model){
        List<Member> members = memberService.findAllMember();
        model.addAttribute("members", members);
        return "members/memberList";
    }


}
