package com.sonichollow.forum.entity;

import com.sonichollow.forum.mapper.PostMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PostSqlTests {
    @Autowired
    PostMapper postMapper;

    @Test
    void postInsertAndSelectTest() {
        Post post1 = new Post();
        post1.setPostName("DFS solution");
        post1.setUsername("MoAo");
        post1.setText("# Hello World\n```cpp\n#include<bits/stdc++.h>\nint main(){cout<<\"Hello World!\"<<endl;return 0;}\n```\n");
        postMapper.insert(post1);

        List<Post> postList = postMapper.selectList(null);
        for (Post post : postList) System.out.println(post);
    }
}
