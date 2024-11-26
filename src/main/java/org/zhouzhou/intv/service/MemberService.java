package org.zhouzhou.intv.service;

import org.springframework.stereotype.Service;

/*
 * 用于Junit单元测试讲解案例
 */
@Service
public class MemberService
{
    public String add(Integer uid)
    {
        System.out.println("---come in addUser,your uid is: "+uid);
        if (uid == -1)
        {
            throw new IllegalArgumentException("parameter is negative。。。。");
        }
        return "ok";
    }

    public int del(Integer uid)
    {
        System.out.println("---come in del,your uid is: "+uid);

        return uid;
    }
}
