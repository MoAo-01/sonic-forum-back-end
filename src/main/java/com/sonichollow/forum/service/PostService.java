package com.sonichollow.forum.service;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sonichollow.forum.entity.Post;
import com.sonichollow.forum.mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Date;

@Service
public class PostService extends ServiceImpl<PostMapper, Post> {
    @Autowired
    private PostMapper postMapper;

//    @Autowired
//    private JedisPool jedisPool;
//
//    @Autowired
//    private TaskExecutor taskExecutor;

    public int PublishPost(Post post){

        //构造帖子
        post.setPostName(post.getPostName());
        post.setUsername(post.getUsername());
        post.setModifiedUser(post.getUsername());
        post.setText(post.getText());
        post.setCreatedTime(new Date());
        post.setLikes(0);
        post.setHates(0);
        post.setIsDelete(0);


        //插入帖子
        postMapper.insert(post);
        System.out.println(post.getPid());

        //更新发帖

        return post.getPid();
    }

    public void updatePost(Post post){
        UpdateWrapper<Post> wrapper = new UpdateWrapper<Post>();
        wrapper.eq("text",post.getText());
        post.setModifiedUser(post.getUsername());
        post.setModifiedTime(new Date());
        postMapper.update(post,wrapper);
    }

    //未测试
//    public String clickLike(int pid, String username) {
//        Jedis jedis = jedisPool.getResource();
//        //被用户点赞
//        jedis.sadd(pid+":like", username);
//        //增加用户获赞数
//        jedis.hincrBy("vote",username+"",1);
//        String result = String.valueOf(jedis.scard(pid+":like"));
//
//        if(jedis!=null){
//            jedisPool.returnResource(jedis);
//        }
//        return result;
//    }

}
