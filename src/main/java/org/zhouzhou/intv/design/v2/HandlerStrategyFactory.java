package org.zhouzhou.intv.design.v2;

import org.springframework.beans.factory.InitializingBean;

public interface HandlerStrategyFactory extends InitializingBean
{
    void getCoca(String parameter);

    //	void afterPropertiesSet() throws Exception;
}

// V2 策略+工厂+InitializingBean
