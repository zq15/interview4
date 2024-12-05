package org.zhouzhou.intv.design.v2;

import org.springframework.stereotype.Component;

@Component
public class PepsiHandlerV2 implements HandlerStrategyFactory
{
    @Override
    public void getCoca(String parameter)
    {
        System.out.println("我是百事可乐-策略+工厂 "+parameter);
    }

    @Override
    public void afterPropertiesSet() throws Exception
    {
        Factory.register("Pepsi",this);
    }
}
