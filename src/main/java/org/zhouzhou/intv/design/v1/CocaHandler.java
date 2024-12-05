package org.zhouzhou.intv.design.v1;

public class CocaHandler implements HandlerStrategy{
    @Override
    public void getCoca(String parameter) {
        System.out.println("我是可口可乐-only策略 "+parameter);
    }
}
