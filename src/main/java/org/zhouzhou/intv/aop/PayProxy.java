package org.zhouzhou.intv.aop;

public class PayProxy implements PayService
{
    private PayService payService;

    //构造注入
    public PayProxy(PayService payService)
    {
        this.payService = payService;
    }

    public void before()
    {
        System.out.println("-----before，开打微信");
    }

    @Override
    public void pay()
    {
        before();
        payService.pay();
        after();
    }

    public void after()
    {
        System.out.println("-----after，关闭微信");
    }
}
