package cn.edu.cqvie.ioc;

import cn.edu.cqvie.ioc.config.AppConfig;
import cn.edu.cqvie.ioc.service.OrderService;
import cn.edu.cqvie.ioc.service.UserService;

public class IocTest {

    public static void main(String[] args) {
        IocApplicationContext applicationContext = new IocApplicationContext(AppConfig.class);
        OrderService orderService = (OrderService)applicationContext.getBean("orderService");
        System.out.println(orderService);
        orderService.test();
    }
}
