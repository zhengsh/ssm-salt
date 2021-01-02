package cn.edu.cqvie.security.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 测试启动类
 *
 * @author zhengsh
 * @date 2020-10-22
 */
@ComponentScan(basePackages = {"cn.edu.cqvie.security.controller"})
@SpringBootApplication
public class DefaultSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(DefaultSecurityApplication.class,args);
    }
}
