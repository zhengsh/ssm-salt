package cn.edu.cqvie.ioc.service;

import cn.edu.cqvie.ioc.annotation.Component;
import cn.edu.cqvie.ioc.annotation.Scope;

/**
 * 用户业务
 *
 * @author zhengsh
 * @date 2020-11-091
 */
@Component
@Scope("prototype")
public class UserService {

    public void test() {
        System.out.println("order test");
    }

}


