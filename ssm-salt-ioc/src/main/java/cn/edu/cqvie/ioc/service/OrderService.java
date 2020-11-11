package cn.edu.cqvie.ioc.service;

import cn.edu.cqvie.ioc.annotation.Autowired;
import cn.edu.cqvie.ioc.annotation.Component;

/**
 * 订单业务
 *
 * @author zhengsh
 * @date 2020-11-091
 */
@Component
public class OrderService {

    @Autowired
    private UserService userService;

    public void test() {
        userService.test();
        System.out.println("order test");
    }
}
