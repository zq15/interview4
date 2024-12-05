package org.zhouzhou.intv.design.v3;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FactoryV3
{
    // 定义策略map缓存
    private static Map<String, AbstractColaHandler> strategyMap = new ConcurrentHashMap<>();


    public static AbstractColaHandler getInvokeStrategy(String str)
    {
        return strategyMap.get(str);
    }

    public static void register(String str,AbstractColaHandler handler)
    {
        System.out.println("str: "+str+"\t handler: "+handler);
        if (null == str || null == handler)
        {
            return;
        }
        strategyMap.put(str,handler);
    }
}
