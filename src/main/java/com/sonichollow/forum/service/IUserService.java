package com.sonichollow.forum.service;

import com.sonichollow.forum.entity.User;

public interface IUserService {

    void register(User user);

    void login(User user);

    void update(User user);
}
