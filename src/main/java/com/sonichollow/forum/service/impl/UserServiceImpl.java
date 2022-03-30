package com.sonichollow.forum.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sonichollow.forum.entity.User;
import com.sonichollow.forum.mapper.UserMapper;
import com.sonichollow.forum.service.IUserService;
import com.sonichollow.forum.service.ex.InsertException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.UUID;

public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;

    public User selectByUsername(String username){
        User user= userMapper.selectOne(new QueryWrapper<User>().eq("username",username));
        return user;
    }

    @Override
    public void register(User user) {
        String username=user.getUsername();
        if(selectByUsername(username)!=null){
            throw new UsernameNotFoundException("用户名重复");
        }
        String oldPassword = user.getPassword();
        String salt = UUID.randomUUID().toString().toUpperCase();
        String newPassword = getMD5Password(oldPassword, salt);

        user.setPassword(newPassword);
        user.setSalt(salt);
        user.setIsDelete(0);
        user.setCreatedUser(user.getUsername());
        user.setModifiedUser(user.getUsername());
        Date date = new Date();
        user.setCreatedTime(date);
        user.setModifiedTime(date);

        Integer rows=userMapper.insert(user);
        if(rows!=1){
            throw new InsertException("插入数据失败");
        }

    }

    @Override
    public void login(User user) {

    }

    @Override
    public void update(User user) {

    }

    /**
     * 密码加盐
     * @param password
     * @param salt
     * @return 加盐密码
     */
    private String getMD5Password(String password, String salt) {
        for (int i = 0; i < 3; i++) {
            password = DigestUtils.md5DigestAsHex((salt + password + salt).getBytes()).toUpperCase();
        }
        return password;
    }

}
