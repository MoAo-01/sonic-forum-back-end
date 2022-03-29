package com.sonichollow.forum.controller;

import com.sonichollow.forum.entity.User;
import com.sonichollow.forum.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class TestController {

    @Autowired
    private UserMapper userMapper;
    @GetMapping("insert")
    public Map inserUser() {

        System.out.println("------test mybatis-plus------");
        System.out.println("------test insert------");
        User user1 = new User();
        user1.setUsername("张三");
        user1.setPassword("123456");
        userMapper.insert(user1);
        return new HashMap();
    }
}
