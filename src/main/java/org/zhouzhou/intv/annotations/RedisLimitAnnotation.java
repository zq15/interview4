package org.zhouzhou.intv.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Documented
public @interface RedisLimitAnnotation
{
    /**
     * 资源的key,唯一
     * 作用：不同的接口，不同的流量控制
     */
    String key() default "";

    /**
     * 最多的访问限制次数
     */
    long permitsPerSecond() default 3;

    /**
     * 过期时间(计算窗口时间)，单位秒默认30
     */
    long expire() default 30;

    /**
     * 默认温馨提示语
     */
    String msg() default "default message:系统繁忙or你点击太快,请稍后再试，谢谢";
}