package org.zhouzhou.intv.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PayAspect
{
    private static final Logger log = LoggerFactory.getLogger(PayAspect.class);

    @Before("execution(public void org.zhouzhou.intv.aop.PayServiceImpl.pay(..))")
    public void beforeNotify()
    {
        System.out.println("-----@Before前置通知");
    }
    @After("execution(public void org.zhouzhou.intv.aop.PayServiceImpl.pay(..))")
    public void afterNotify()
    {
        System.out.println("-----@After后置通知");
    }
    @AfterReturning("execution(public void org.zhouzhou.intv.aop.PayServiceImpl.pay(..))")
    public void afterReturningNotify()
    {
        System.out.println("-----@AfterReturning返回通知");
    }
    @AfterThrowing("execution(public void org.zhouzhou.intv.aop.PayServiceImpl.pay(..))")
    public void afterThrowingNotify()
    {
        System.out.println("-----@AfterThrowing异常通知");
    }

    @Around("execution(public void org.zhouzhou.intv.aop.PayServiceImpl.pay(..))")
    public Object aroundNotify(ProceedingJoinPoint proceedingJoinPoint) throws Throwable
    {
        Object retValue = null;
        try {
            System.out.println("-----@Around环绕通知AAA");
            retValue = proceedingJoinPoint.proceed();//放行
        } catch (Exception e) {
            System.out.println("发生异常: " + e);
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            System.out.println("-----@Around环绕通知BBB");
        }

        return retValue;
    }
}
