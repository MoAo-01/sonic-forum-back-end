package com.sonichollow.forum;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sonichollow.forum.entity.Post;
import com.sonichollow.forum.entity.User;
import com.sonichollow.forum.mapper.PostMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.sonichollow.forum.mapper.UserMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@SpringBootTest
class ForumApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PostMapper postMapper;
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

    @DisplayName("测试")
    @Test
    void contextLoads(){
        //查
        List<Post> post = postMapper.selectList(null);
        post.forEach(System.out::println);
        //update
        Post uppost = new Post();
        uppost.setUsername("Alice");
        uppost.setPostName("TestPost");
        uppost.setText("This is a post");
        int update = postMapper.update(uppost,null);
        System.out.println(update);
        //insert INSERT INTO post ( username, post_name, text ) VALUES ( ?, ?, ? )
        Post post3 = new Post();
        post3.setUsername("Bob");
        post3.setPostName("TestPost");
        post3.setText("This is a post");
        int result = postMapper.insert(post3);
        log.warn("insert => {}",result);
        log.warn("id => {}",post3.getPid());

        //delete
        //通过id删除用户信息 DELETE FROM post WHERE =?
        int delResult = postMapper.deleteById(5);
        log.warn("delResult => {}",delResult);


        //条件删除
        //DELETE FROM post WHERE text = ? AND username = ?
        Map<String,Object> map = new HashMap<>();
        map.put("username","Bob");
        map.put("text","This is a post");
        int result3 = postMapper.deleteByMap(map);
        log.warn("result3 => {}",result3);

        //通过多个id批量删除
        List<Integer> list= Arrays.asList(1,2,3);
        int result4 = postMapper.deleteBatchIds(list);
        log.warn("result4 => {}",result3);

    }

}
