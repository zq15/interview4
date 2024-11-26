package org.zhouzhou.intv.service;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class MemberServiceTest {

//    @Resource
//    private MemberService memberService;
//
//    @Test
//    void add() {
//        String result = memberService.add(1);
//        assertEquals("ok", result);
//    }

//    @MockBean
//    private MemberService memberService2;
//
//    @Test
//    void m2_NotMockRule()
//    {
//        String result = memberService2.add(2);
//        assertEquals("ok",result);
//
//        System.out.println("----m2_NotMockRule over");
//    }
//
//    @Test
//    void m2_WithMockRule()
//    {
//        when(memberService2.add(3)).thenReturn("ok");//不真的进入数据库/MQ，不落盘，改变return
//
//        String result = memberService2.add(3);
//        assertEquals("ok",result);
//
//        System.out.println("----m2_WithMockRule over");
//    }

    //==========第三组==========
    //@Resource //真实调用
    //@MockBean//如果没有指定规则的话，统统返回默认值，对象为null，数字为零;制定了mock规则就按照规则走
    @SpyBean //有规则按照规则走，没有规则走真实
    private MemberService memberService3;
    @Test
    void m3()
    {
        when(memberService3.add(2)).thenReturn("ok"); // 定义mock方法行为
        String result = memberService3.add(2);
        System.out.println("----add result:  "+result);
        assertEquals("ok",result);

        int result2 = memberService3.del(3);
        System.out.println("----del result2:  "+result2);
        assertEquals(3,result2);

        //跨部门调用，不是写代码，累的是心，协调工作。    zzyybs@126.com
        System.out.println("----over");
    }


}