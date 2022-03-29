package com.sonichollow.forum.entity;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sonichollow.forum.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserSqlTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    void testMybatisPlus() {
        System.out.println("------test mybatis-plus------");
        System.out.println("------test insert------");
        User user1 = new User();
        user1.setUsername("Alice");
        user1.setPassword("123456");
        userMapper.insert(user1);

        User user2 = new User();
        user2.setUsername("Bob");
        user2.setPassword("123456");
        userMapper.insert(user2);

        System.out.println("------test select all------");
        List<User> userList=userMapper.selectList(null);
        for(User user:userList){
            System.out.println(user);
        }
        System.out.println("------test successful------");
    }

    @Test
    void testSelectByUsername(){
        System.out.println("------test select by username------");

//        Map map=new HashMap<>();
//        map.put("username","Alice");
//        List<User> userList=userMapper.selectByMap(map);
//        userList.forEach(System.out::println);


        System.out.println(
                userMapper.selectOne(new QueryWrapper<User>().eq("username", "Alice"))
        );

        System.out.println("------test successful------");
    }
}
