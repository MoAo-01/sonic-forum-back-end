package com.sonichollow.forum.service;

import com.sonichollow.forum.entity.User;
import com.sonichollow.forum.service.ex.NoSuchUsernameException;
import com.sonichollow.forum.service.ex.ServiceException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class UserServiceTests {
    @Autowired
    private UserService userService;


    @Test
    public void register(){
        try {
            User user=new User();
            user.setUsername("Jack");
            user.setPassword("123456");
            userService.register(user);
            System.out.println("注册成功");
        }
        catch (ServiceException e){
            System.err.println(e);
        }
    }

    @Test
    public void loginSuccess(){
        try{
            User user=new User();
            user.setUsername("Jack");
            user.setPassword("123456");
            User selectResult=userService.login(user);
            System.out.println(selectResult);
            System.out.println("登录成功");
        }
        catch (ServiceException e){
            System.err.println(e);
        }
    }

    @Test
    public void loginNoSuchUsername(){
        try{
            User user=new User();
            user.setUsername("Jackie");
            user.setPassword("123456");
            User selectResult=userService.login(user);
            System.out.println(selectResult);
            System.out.println("登录成功");
        } catch (ServiceException e){
            System.err.println(e);
        }

    }

    @Test
    public void loginPasswordWrong(){
        try{
            User user=new User();
            user.setUsername("Jack");
            user.setPassword("12345");
            User selectResult=userService.login(user);
            System.out.println(selectResult);
            System.out.println("登录成功");
        }
        catch (ServiceException e){
            System.err.println(e);
        }
    }

    @Test
    public void update(){
        User user=new User();
        user.setUsername("Alice");
        user.setGender(1);
        user.setEmail("Alice@google.com");
        Date date=new Date();
        user.setModifiedTime(date);
        user.setModifiedUser("Alice");
        userService.update(user);
    }
}
