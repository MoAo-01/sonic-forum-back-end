package com.sonichollow.forum.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.sonichollow.forum.entity.User;
import com.sonichollow.forum.mapper.UserMapper;
import com.sonichollow.forum.service.ex.InsertException;
import com.sonichollow.forum.service.ex.NoSuchUsernameException;
import com.sonichollow.forum.service.ex.PasswordWrongException;
import com.sonichollow.forum.service.ex.RepeatUsernameException;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    private User selectByUsername(String username){
        User user;
        try{
            user=userMapper.selectOne(new QueryWrapper<User>().eq("username",username));
            return user;
        }
        catch (Exception e){
            return null;
        }
    }

    public void register(User user) {
        String username=user.getUsername();
        if(selectByUsername(username)!=null){
            throw new RepeatUsernameException("用户名重复");
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

    public User login(User user) {
        String username=user.getUsername();
        String password=user.getPassword();
        User selectResult=selectByUsername(username);
        if(selectResult==null){
            throw new NoSuchUsernameException("用户不存在");
        }
        String salt=selectResult.getSalt();
        String newPassword=getMD5Password(password,salt);
        if(!selectResult.getPassword().equals(newPassword)){
            throw new PasswordWrongException("密码错误");
        }
        return selectResult;
    }


    /**
     * 此服务在login成功之后的基础上运行
     * @param user
     */
    public void update(User user) {
        UpdateWrapper<User> wrapper = new UpdateWrapper<User>();
        wrapper.eq("username",user.getUsername());
        user.setModifiedUser(user.getUsername());
        user.setModifiedTime(new Date());
        userMapper.update(user,wrapper);
    }

    private String getMD5Password(String password, String salt) {
        for (int i = 0; i < 3; i++) {
            password = DigestUtils.md5DigestAsHex((salt + password + salt).getBytes()).toUpperCase();
        }
        return password;
    }

}
