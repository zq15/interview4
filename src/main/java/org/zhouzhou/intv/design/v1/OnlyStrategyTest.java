package org.zhouzhou.intv.design.v1;

/**
 * V2 ,用策略模式替代每个分支里面的业务逻辑
 * 每个策略替代一个分支里面的代码，减少繁杂度
 */
public class OnlyStrategyTest {
    /**
     * 每个分支里面的业务逻辑都被分工拿走了，各回各家，自行处理，
     * 大大减轻了more_IfElse里面分支业务逻辑的复杂度
     * @param parameter
     */
    public void more_IfElse(String parameter)
    {
        if ("Pepsi".equalsIgnoreCase(parameter)) {
            new PepsiHandler().getCoca(parameter);
        }else if ("Coca".equalsIgnoreCase(parameter)){
            new CocaHandler().getCoca(parameter);
        }else if ("Wahaha".equalsIgnoreCase(parameter)){
            new WahahaHandler().getCoca(parameter);
        }
    }

    public static void main(String[] args)
    {
        new OnlyStrategyTest().more_IfElse("wahaha");
    }
}
