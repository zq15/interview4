package org.zhouzhou.intv.juc;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.threadpool.TtlExecutors;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;

/**
 * ThreadLocal  VS  InheritableThreadLocal VS  TransmittableThreadLocal
 */
@Slf4j
public class ThreadLocalDemoV3 {
    public static void main(String[] args) {
//        m1();
//        m2();
//        m3();  //InheritableThreadLocal
//        m4();
        m5();   // TransmittableThreadLocal
    }

    private static void m5()
    {
        TransmittableThreadLocal<String> transmittableThreadLocal = new TransmittableThreadLocal<>();
        //为了看到效果，这里创建大小为1的线程池方便看到效果,池中只有1个线程才有效果，池中只有1个线程才有效果
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        //这里需要用 TtlExecutors.getTtlExecutorService 将原线程池包装下
        threadPool = TtlExecutors.getTtlExecutorService(threadPool);

        //这里是主线程，使用 transmittableThreadLocal.set 放入值：Java
        transmittableThreadLocal.set(Thread.currentThread().getName()+"-Java");
        log.info("major:{}", transmittableThreadLocal.get());

        //在线程池中通过 transmittableThreadLocal 拿值，看看能否拿到 刚才放入的Java？
        threadPool.execute(() -> {
            log.info("threadPool第1次获取 major:{}", transmittableThreadLocal.get());
        });

        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println();
        System.out.println();

        //这里又在主线程中放入了Vue
        transmittableThreadLocal.set(Thread.currentThread().getName()+"-Vue我已经修改了，O(∩_∩)O");
        log.info("major:{}", transmittableThreadLocal.get());

        //这里又在线程池中通过 transmittableThreadLocal.get 方法拿值，看看能否拿到 刚才放入的Vue？
        threadPool.execute(() -> {
            //在线程池中通过 transmittableThreadLocal 拿值，看看能否拿到？
            log.info("threadPool第2次获取 major:{}", transmittableThreadLocal.get());
        });
        System.out.println();

        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        threadPool.shutdown();

        /**
         * 解决线程池中线程因为复用而不能取得外部线程数据的问题
         */
    }

    private static void m4()
    {
        //InheritableThreadLocal：遇到线程池，会有问题

        InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal();
        //这里是主线程，使用 InheritableThreadLocal.set 放入值：Java
        inheritableThreadLocal.set(Thread.currentThread().getName()+"-Java");
        log.info("major:{}", inheritableThreadLocal.get());

        //为了看到效果，这里创建大小为1的线程池方便看到效果,池中只有1个线程才有效果，池中只有1个线程才有效果
        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        //在线程池中通过 InheritableThreadLocal 拿值，看看能否拿到 刚才放入的Java？
        threadPool.execute(() -> {
            log.info("threadPool第1次获取 major:{}", inheritableThreadLocal.get());
        });

        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println();
        System.out.println();

        //这里又在主线程中放入了Vue
        inheritableThreadLocal.set(Thread.currentThread().getName()+"-Vue我已经修改了，O(∩_∩)O");
        log.info("major:{}", inheritableThreadLocal.get());

        //这里又在线程池中通过 InheritableThreadLocal.get 方法拿值，看看能否拿到 刚才放入的Vue？
        threadPool.execute(() -> {
            //在线程池中通过 inheritableThreadLocal 拿值，看看能否拿到？
            log.info("threadPool第2次获取 major:{}", inheritableThreadLocal.get());  // threadPool第2次获取 major:main-Java
        });

        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        threadPool.shutdown();

        /**
         * new新建可以
         * 复用不好使，没有new
         */
    }

    private static void m3()
    {
        InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal();

        //这里是主线程，使用 InheritableThreadLocal.set 放入值：Java
        inheritableThreadLocal.set(Thread.currentThread().getName()+"-Java");
        log.info("major:{}", inheritableThreadLocal.get());

        //新建线程thread1，在子线程thread1中去ThreadLocal中拿main线程放入值，能否拿到？
        //使用InheritableThreadLocal，子线程可以获得父线程set进去的值
        new Thread(() -> {
            log.info("major:{}", inheritableThreadLocal.get());
        }, "thread1").start();

        new Thread(() -> {
            log.info("major:{}", inheritableThreadLocal.get());
        }, "thread2").start();

        new Thread(() -> {
            log.info("major:{}", inheritableThreadLocal.get());
        }, "thread3").start();
    }

    private static void m2()
    {
        ThreadLocal<String> threadLocal = ThreadLocal.withInitial(() -> null);
        //这里是主线程，ThreadLocal中设置了值：Java
        threadLocal.set(Thread.currentThread().getName()+"-Java");
        log.info("major:{}", threadLocal.get());

        //新建线程thread1，在子线程thread1中去ThreadLocal中拿main线程放入值，能否拿到？
        //自己set的才能自己get，别人的取不到,分灶吃饭，自取自划
        new Thread(() -> {
            log.info("major:{}", threadLocal.get());
        }, "thread1").start();
    }

    public static void m1() {
        // ThreadLocal 可以在当前线程中共享数据，set/get 需要在同一个线程中执行才可以，别人的取不到
        ThreadLocal<String> threadLocal = ThreadLocal.withInitial(() -> null);

        threadLocal.set(Thread.currentThread().getName() + "-java");
        log.info("major{}", threadLocal.get()); // java

        // 新建线程1 ，设置 Flink，然后取出学科名看看
        new Thread(() -> {
            log.info("major{}", threadLocal.get()); // 看看能否取得main线程上一步写的值 null
            threadLocal.set(Thread.currentThread().getName() + "-kotlin");
            log.info("major{}", threadLocal.get()); // kotlin
        }, "thread1").start();
        System.out.println();

        // 暂停几秒钟线程
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 新建线程2 ，设置 Spark，然后取出学科名看看
        new Thread(() -> {
            log.info("major{}", threadLocal.get()); // 看看能否取得main线程上一步写的值 null
            threadLocal.set(Thread.currentThread().getName() + "-Spark");
            log.info("major{}", threadLocal.get()); // spark
        }, "thread2").start();

        CompletableFuture.supplyAsync(() -> {
            log.info("major{}", threadLocal.get()); // 看看能否取得main线程上一步写的值 null
            threadLocal.set(Thread.currentThread().getName() + "-mysql");
            log.info("major{}", threadLocal.get()); // mysql
            return threadLocal.get();
        });
        System.out.println();

        // 暂停毫秒
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
