package cn.edu.cqvie.api;

import org.apache.dubbo.common.URL;

/**
 * 包装类
 *
 * @author zhengsh
 * @date 2021-01-31
 */
public class CarWapper implements Car {

    private Car car;

    public CarWapper(Car car) {
        this.car = car;
    }


    @Override
    public void start() {
        System.out.println("wapper");
        car.start();
    }

    @Override
    public String color(URL url) {
        return null;
    }
}

