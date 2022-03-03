package com.market.main.controller;

import com.market.main.entity.Post;
import com.market.main.entity.PostForm;
import com.market.main.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/posts")
    public String PostList(Model model){
        List<Post> posts = postService.findAllPost();
        model.addAttribute("posts", posts);
        return "/post/boardList";
    }

    @PostMapping("/post/new")
    public String registerPost(PostForm postForm, BindingResult result){
        if(result.hasErrors())
            return "post/createPostForm";
        else{
            postService.registerPost(postForm);
            return "redirect:/";
        }
    }

    @GetMapping("/post/new")
    public String createPostForm(Model model){
        model.addAttribute("postForm", new PostForm());
        return "/post/createPostForm";
    }

}
