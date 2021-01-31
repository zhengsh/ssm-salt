package cn.edu.cqvie.api;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.extension.SPI;

@SPI
public interface Car {

    void start();

    @Adaptive
    String color(URL url);
}
