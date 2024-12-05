package org.zhouzhou.intv.design.v1;

public class PepsiHandler implements HandlerStrategy{
    @Override
    public void getCoca(String parameter) {
        System.out.println("PepsiHandler");
    }
}
