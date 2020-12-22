package cn.edu.cqvie.aop.service;

import cn.edu.cqvie.aop.annotation.Mark;
import org.springframework.stereotype.Service;

/**
 * 用户处理逻辑
 *
 * @author zhengsh
 * @date 2020-11-10
 */
@Mark
public interface UserService {

    public void test();
}
