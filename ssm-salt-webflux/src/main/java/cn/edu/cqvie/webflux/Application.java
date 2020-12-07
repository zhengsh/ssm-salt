package cn.edu.cqvie.webflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

/**
 * 启动类
 *
 * @author zhengsh
 * @date 2020-12-07
 */
@SpringBootApplication
@EnableR2dbcRepositories
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
