package org.zhouzhou.intv.junit.auto;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * Junit+反射+注解浅谈自动测试框架设计
 *
 * 需求
 * 1 我们自定义注解@AtguiguTest
 * 2 将注解AtguiguTest加入需要测试的方法
 * 3 类AutoTestClient通过反射检查，哪些方法头上标注了@AtguiguTest注解会自动进行单元测试
 */
@Slf4j
public class AutoTestClient
{
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException
    {
        //家庭作业，抽取一个方法，（class，p....）
        CalcHelpDemo calcHelpDemo = new CalcHelpDemo();
        int para1 = 10;
        int para2 = 0;


        Method[] methods = calcHelpDemo.getClass().getMethods();
        AtomicInteger bugCount = new AtomicInteger();
        // 要写入的文件路径（如果文件不存在，会创建该文件）
        String filePath = "BugReport"+ (DateUtil.format(new Date(), "yyyyMMddHHmmss"))+".txt";

        for (int i = 0; i < methods.length; i++)
        {
            if (methods[i].isAnnotationPresent(AtguiguTest.class))
            {
                try
                {
                    methods[i].invoke(calcHelpDemo,para1,para2);//放行
                } catch (Exception e) {
                    bugCount.getAndIncrement();
                    log.info("异常名称:{},异常原因:{}",e.getCause().getClass().getSimpleName(),e.getCause().getMessage());


                    FileUtil.writeString(methods[i].getName()+"\t"+"出现了异常"+"\n", filePath, "UTF-8");
                    FileUtil.appendString("异常名称:"+e.getCause().getClass().getSimpleName()+"\n", filePath, "UTF-8");
                    FileUtil.appendString("异常原因:"+e.getCause().getMessage()+"\n", filePath, "UTF-8");
                }finally {
                    FileUtil.appendString("异常数:"+bugCount.get()+"\n", filePath, "UTF-8");
                }
            }
        }
    }
}

