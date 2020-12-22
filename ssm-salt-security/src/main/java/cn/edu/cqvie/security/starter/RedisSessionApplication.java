package cn.edu.cqvie.security.starter;

import cn.edu.cqvie.security.config.RedisSessionSecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@ComponentScan(basePackages = {
        "cn.edu.cqvie.security.controller",
        "cn.edu.cqvie.security.service.impl"
})
@Import(RedisSessionSecurityConfig.class)
@SpringBootApplication
public class RedisSessionApplication {


    public static void main(String[] args) {
        SpringApplication.run(RedisSessionApplication.class, args);
    }
}
