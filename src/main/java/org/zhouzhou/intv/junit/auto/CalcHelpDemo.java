package org.zhouzhou.intv.junit.auto;

public class CalcHelpDemo
{
    public int mul(int x ,int y)
    {
        return x * y;
    }

    @AtguiguTest
    public int div(int x ,int y)
    {
        return x / y;
    }
    @AtguiguTest
    public void thank(int x ,int y)
    {
        System.out.println("3ks，help me test bug");
    }
}
