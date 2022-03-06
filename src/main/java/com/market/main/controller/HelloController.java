package com.market.main.controller;

import com.market.main.config.auth.LoginUser;
import com.market.main.config.auth.dto.MemberSession;
import com.market.main.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class HelloController {


    @GetMapping("/")
    public String hello(Model model, @LoginUser MemberSession member){
        if(member != null){
            model.addAttribute("userName", member.getName());
        }
        return "home";
    }
}
