package org.zhouzhou.intv.exception;

/**
 * Redis限流自定义异常
 */
public class RedisLimitException extends RuntimeException
{
    public RedisLimitException(String msg)
    {
        super(msg);
    }
}
