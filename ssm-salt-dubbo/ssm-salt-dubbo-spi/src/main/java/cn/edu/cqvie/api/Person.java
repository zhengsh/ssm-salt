package cn.edu.cqvie.api;

import org.apache.dubbo.common.extension.SPI;

@SPI
public interface Person {

    Car getCar();
}
