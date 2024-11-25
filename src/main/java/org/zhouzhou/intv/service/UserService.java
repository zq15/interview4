package org.zhouzhou.intv.service;

import org.zhouzhou.intv.entity.User;

public interface UserService {
    public int addUser(User user);

    public User getUserById(Integer id);
}
