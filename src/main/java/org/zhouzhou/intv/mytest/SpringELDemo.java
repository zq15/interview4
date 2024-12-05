package org.zhouzhou.intv.mytest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

@Slf4j
public class SpringELDemo {
    public static void main(String[] args) {
        // 1. log 日志占位符{}替换
        log.info("log: {}", "abcd");
        System.out.println();

        // 2. String.format 占位符替换
        String result = String.format("%S,java", "zhouzhou study");
        System.out.println(result);

        // 3. SpringEL 表达式
        String var = "#userid";

        SpelExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression(var);

        EvaluationContext context = new StandardEvaluationContext();
        context.setVariable("userid", "1253");

        String value = expression.getValue(context, String.class);
        System.out.println(value);
    }
}
