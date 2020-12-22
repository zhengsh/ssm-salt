package cn.edu.cqvie.aop;

import cn.edu.cqvie.aop.config.AopConfig;
import cn.edu.cqvie.aop.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AopTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AopConfig.class);
        UserService userService = context.getBean(UserService.class);
        userService.test();
    }
}
