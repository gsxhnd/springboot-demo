package xyz.gsxhnd.springboot-demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("xyz.gsxhnd.springboot-demo.api.mapper")
public class SlsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SlsApplication.class, args);
    }
}
