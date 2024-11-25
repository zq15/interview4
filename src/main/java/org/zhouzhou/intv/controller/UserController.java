package org.zhouzhou.intv.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.zhouzhou.intv.entity.User;
import org.zhouzhou.intv.service.UserService;

@RestController
public class UserController
{
    @Resource
    private UserService userService;

    @PostMapping(value = "/user/add")
    public int addUser(@RequestBody User user)
    {
        return userService.addUser(user);
    }

    @GetMapping(value = "/user/{id}")
    public User getUserById(@PathVariable("id") Integer id)
    {
        return userService.getUserById(id);
    }

}
/*

###
POST http://localhost:24618/user/add
Content-Type: application/json

{
  "username": "尚硅谷05",
  "password": "13911111115",
  "sex": "1"
}
*/