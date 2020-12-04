package cn.edu.cqvie.aop;

import cn.edu.cqvie.aop.service.UserService;
import org.springframework.aop.framework.ProxyFactory;

public class AopTest {

    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new UserService());

    }
}
