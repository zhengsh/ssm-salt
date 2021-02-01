package cn.edu.cqvie.api;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.extension.SPI;

@SPI
public interface Car {

    void start();

    /**
     * 方法被代理需要两个步骤：
     * 1. 增加 @Adaptive 注解
     * 2. URL 参数
     *
     * @param url
     * @return
     */
    @Adaptive
    String color(URL url);

//    String sayHello();
//
//    String sayHello(URL url);
}
