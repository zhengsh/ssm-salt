package cn.edu.cqvie.provider.impl;

import cn.edu.cqvie.provider.HelloService;

public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String hello) {
        return "say hello!";
    }
}
