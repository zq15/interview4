package org.zhouzhou.intv.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyData //资源类
{
    ThreadLocal<Integer> threadLocalField = ThreadLocal.withInitial(() -> 0);

    public void add()
    {
        threadLocalField.set(1 + threadLocalField.get());
    }
}

public class ThreadLocalDemoV2 {
    public static void main(String[] args)
    {
        MyData myData = new MyData();
        //模拟一个银行有3个办理业务的受理窗口
        ExecutorService threadPool = Executors.newFixedThreadPool(3);

        try
        {
            //10个顾客(请求线程),池子里面有3个受理线程，负责处理业务
            for (int i = 1; i <=10; i++) {
                int finalI = i;
                threadPool.submit(() -> {
                    try {
                        Integer beforeInt = myData.threadLocalField.get();
                        myData.add();
                        Integer afterInt = myData.threadLocalField.get();
                        System.out.println(Thread.currentThread().getName()+"\t"+"工作窗口\t "+
                            "受理第： "+ finalI + "个顾客业务"+
                            "\t beforeInt: "+ beforeInt+"\t afterInt： "+afterInt);
                    } finally {
                        // 不加会出现线程复用导致的问题
//                        myData.threadLocalField.remove();
                    }
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }
    }
}
