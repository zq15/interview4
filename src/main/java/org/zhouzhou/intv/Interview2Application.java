package org.zhouzhou.intv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("org.zhouzhou.interview2.mapper")
public class Interview2Application {

    public static void main(String[] args)
    {
        SpringApplication.run(Interview2Application.class, args);
    }
}
