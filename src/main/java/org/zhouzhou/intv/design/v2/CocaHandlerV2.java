package org.zhouzhou.intv.design.v2;

import org.springframework.stereotype.Component;

@Component
public class CocaHandlerV2 implements HandlerStrategyFactory
{
    @Override
    public void getCoca(String parameter)
    {
        System.out.println("我是可口可乐-策略+工厂 "+parameter);
    }

    @Override
    public void afterPropertiesSet() throws Exception
    {
        //K          //V
        Factory.register("Coca",this);
    }
}
