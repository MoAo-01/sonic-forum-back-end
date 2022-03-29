package com.sonichollow.forum;

import com.sonichollow.forum.entity.User;
import org.junit.jupiter.api.Test;
import com.sonichollow.forum.mapper.UserMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@SpringBootTest(classes = ForumApplication.class)
class ForumApplicationTests {
    @Autowired
    private UserMapper userMapper;


    @Test
    void testMybatisPlus() {
        System.out.println("------test mybatis-plus------");
        System.out.println("------test insert------");
        User user1 = new User();
        user1.setUsername("张飞");
        user1.setPassword("123456");
        userMapper.insert(user1);

        User user2 = new User();
        user2.setUsername("李四");
        user2.setPassword("123456");
        userMapper.insert(user2);

        System.out.println("------test select all------");
        List<User> userList=userMapper.selectList(null);
        for(User user:userList){
            System.out.println(user);
        }
        System.out.println("------test successful------");
    }

}
