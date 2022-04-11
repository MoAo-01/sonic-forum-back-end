package com.sonichollow.forum.controller;


import com.sonichollow.forum.entity.Post;
import com.sonichollow.forum.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostService postService;


    //去发帖页面
    @RequestMapping("/toPublish")
    public String toPublish(Model model, Post post){
        return "publish";
    }

    //发帖

    /**
     *
     * @param model
     * @param post
     * @return
     */
    @RequestMapping("/Publish")
    public String publish(Model model, Post post){
        int id = postService.PublishPost(post);
        return "redirect:publishedPost?pid"+id;
    }
//
    //去帖子详情页
    @RequestMapping("/publishedPost")
    public String postDetailPage(Model model,int pid,HttpSession session){
        //注入内容需要更改
//        Integer sessionUid = (Integer) session.getAttribute("pid");
//        //获取帖子信息 浏览量
//        Post post = postService.getById(pid);
//        model.addAttribute("post",post);
        return "postPage";
    }
}
