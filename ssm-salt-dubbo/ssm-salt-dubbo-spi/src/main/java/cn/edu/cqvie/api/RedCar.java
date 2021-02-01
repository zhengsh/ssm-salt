package cn.edu.cqvie.api;

import org.apache.dubbo.common.URL;

public class RedCar implements Car {

    @Override
    public void start() {
        System.out.println(color(null) + " car start!");
    }

    @Override
    public String color(URL url) {
        return "red";
    }

//    @Override
//    public String sayHello() {
//        return "say hello!";
//    }


}
