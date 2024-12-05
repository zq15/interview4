package org.zhouzhou.intv;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("org.zhouzhou.intv.mapper")
public class Interview2Application {

    @Resource
    private ThreadPoolTaskExecutor threadPool;

    @PostConstruct
    public void getThreadPoolConfig()
    {
        System.out.println("*******测试threadPool getCorePoolSize: "+threadPool.getCorePoolSize());
        System.out.println("*******测试threadPool getMaxPoolSize: "+threadPool.getMaxPoolSize());
        System.out.println("*******测试threadPool getQueueCapacity: "+threadPool.getQueueCapacity());
        System.out.println("*******测试threadPool getKeepAliveSeconds: "+threadPool.getKeepAliveSeconds());
    }

    public static void main(String[] args)
    {
        SpringApplication.run(Interview2Application.class, args);
    }
}
