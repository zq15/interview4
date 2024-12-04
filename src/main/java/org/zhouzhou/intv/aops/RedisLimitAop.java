package org.zhouzhou.intv.aops;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.stereotype.Component;
import org.zhouzhou.intv.annotations.RedisLimitAnnotation;
import org.zhouzhou.intv.exception.RedisLimitException;

@Slf4j
@Aspect
@Component
public class RedisLimitAop {
    Object result = null;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    private DefaultRedisScript<Long> redisLuaScript;
    @PostConstruct
    public void init()
    {
        redisLuaScript = new DefaultRedisScript<>();
        redisLuaScript.setResultType(Long.class);
        redisLuaScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("rateLimiter.lua")));
    }

    @Around("@annotation(org.zhouzhou.intv.annotations.RedisLimitAnnotation)")
    public Object around(ProceedingJoinPoint joinPoint)
    {
        System.out.println("---------环绕通知1111111");

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        //拿到RedisLimitAnnotation注解，如果存在则说明需要限流，容器捞鱼思想
        RedisLimitAnnotation redisLimitAnnotation = method.getAnnotation(RedisLimitAnnotation.class);

        if (redisLimitAnnotation != null)
        {
            //获取redis的key
            String key = redisLimitAnnotation.key();
            String className = method.getDeclaringClass().getName();
            String methodName = method.getName();

            String limitKey = key +"\t"+ className+"\t" + methodName;
            log.info(limitKey);

            if (null == key)
            {
                throw new RedisLimitException("it's danger,limitKey cannot be null");
            }

            long limit = redisLimitAnnotation.permitsPerSecond();
            long expire = redisLimitAnnotation.expire();
            List<String> keys = new ArrayList<>();
            keys.add(key);

            Long count = stringRedisTemplate.execute(
                redisLuaScript,
                keys,
                String.valueOf(limit),
                String.valueOf(expire));

            System.out.println("Access try count is "+count+" \t key= "+key);
            if (count != null && count == 0)
            {
                System.out.println("启动限流功能key: "+key);
                // 第一学历统招本科，愿意跟着阳哥学技术，需要内推或高阶java资料学习的同学发邮件zzyybs@126.com
                //throw new RedisLimitException(redisLimitAnnotation.msg());
                return redisLimitAnnotation.msg();
            }
        }


        try {
            result = joinPoint.proceed();//放行
//            int i = 1/0;
        } catch (Throwable e) {
            System.out.println(e);
            throw new RuntimeException(e);
        } finally {
            System.out.println("3333333333333");
        }

        System.out.println("---------环绕通知2222222");
        System.out.println();
        System.out.println();

        return result;
    }

}
