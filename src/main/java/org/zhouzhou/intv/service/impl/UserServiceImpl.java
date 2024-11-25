package org.zhouzhou.intv.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.zhouzhou.intv.entity.User;
import org.zhouzhou.intv.service.UserService;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Override
    public int addUser(User user) {
        return 0;
    }

    @Override
    public User getUserById(Integer id) {
        return null;
    }
}
