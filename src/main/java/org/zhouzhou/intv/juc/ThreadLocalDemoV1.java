package org.zhouzhou.intv.juc;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;
import lombok.Getter;

class SU7 {
    @Getter
    private int saleTotal;//本门店总体销售额
    public synchronized void saleTotal()
    {
        saleTotal++;
    }
    ThreadLocal<Integer> salePersonal = ThreadLocal.withInitial(() -> 0);
    public void salePersonal(){
        salePersonal.set(1 + salePersonal.get());
    }
}

public class ThreadLocalDemoV1 {
    public static void main(String[] args) throws InterruptedException {
        SU7 su7 = new SU7();
        CountDownLatch countDownLatch = new CountDownLatch(3);

        for (int i = 0; i <= 3; i++) {
            new Thread(() -> {
                try {
                    for (int j = 0; j <= new Random().nextInt(3)+1; j++) { // new Random(3) 返回值 0-2
                        su7.saleTotal(); // 本门店销售总和统计全部加
                        su7.salePersonal();
                    }
                    System.out.println(Thread.currentThread().getName()+"\t"+"个人销售额: "+su7.salePersonal.get());
                } finally {
                    countDownLatch.countDown();
                }
            }, String.valueOf(i)).start();
        }

        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"\t"+"销售总额: " + su7.getSaleTotal());
    }
}
