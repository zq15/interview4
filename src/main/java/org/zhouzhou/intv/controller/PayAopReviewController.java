package org.zhouzhou.intv.controller;

import cn.hutool.core.util.IdUtil;
import jakarta.annotation.Resource;
import org.springframework.boot.SpringBootVersion;
import org.springframework.core.SpringVersion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zhouzhou.intv.aop.PayService;

@RestController
public class PayAopReviewController
{
    @Resource
    private PayService payService;

    @GetMapping(value = "/pay/aop")
    public String pay()
    {
        System.out.println("SpringVersion: "+ SpringVersion.getVersion()+"\t"+ "SpringBootVersion: "+ SpringBootVersion.getVersion());

        payService.pay();


        return IdUtil.simpleUUID();
    }
}
