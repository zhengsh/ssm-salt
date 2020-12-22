package cn.edu.cqvie.aop.service.impl;

import cn.edu.cqvie.aop.annotation.Mark;
import cn.edu.cqvie.aop.service.UserService;
import org.springframework.stereotype.Service;

/**
 * 用户处理逻辑
 *
 * @author zhengsh
 * @date 2020-11-10
 */
@Mark("user-mark")
@Service
public class UserServiceImpl implements UserService {

    public void test() {
        System.out.println("test invoke!");
    }
}
