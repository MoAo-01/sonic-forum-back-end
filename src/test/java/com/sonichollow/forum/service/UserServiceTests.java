package com.sonichollow.forum.service;

import com.sonichollow.forum.entity.User;
import com.sonichollow.forum.service.ex.ServiceException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceTests {
    @Autowired
    private IUserService userService;

    @Test
    void register(){
        try {
            User user=new User();
            user.setUsername("王小明");
            user.setPassword("123456");
            userService.register(user);
            System.out.println("注册成功");
        }
        catch (ServiceException e){
            System.out.println(e);
        }
    }
}
