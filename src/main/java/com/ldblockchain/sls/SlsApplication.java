package com.ldblockchain.sls;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ldblockchain.sls.api.mapper")
public class SlsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SlsApplication.class, args);
    }
}
