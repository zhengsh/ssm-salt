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

        for (int i = 2020; i <= 2020; i++) { //Ara You Ok!
            System.out.println("we work in 996, love life"); // 2020 总结：代码太多，故事太少
        } //2020 Say Goodbye
    }
}
