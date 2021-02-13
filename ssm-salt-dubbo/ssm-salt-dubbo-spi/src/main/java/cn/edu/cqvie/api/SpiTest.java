package cn.edu.cqvie.api;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;

import java.util.ServiceLoader;

public class SpiTest {

    public static void main(String[] args) {

        // Java 提供的 SPI
        ServiceLoader<Car> cars = ServiceLoader.load(Car.class);
        for (Car car : cars) {
            car.start();
        }

        // Dubbo 提供的 SPI
        ExtensionLoader<Car> extensionLoader = ExtensionLoader
                .getExtensionLoader(Car.class);
        Car car = extensionLoader.getExtension("red");
        System.out.println(car);
        car.start();


        // Dubbo URL
        ExtensionLoader<Person> extensionLoader2 = ExtensionLoader
                .getExtensionLoader(Person.class);
        Person person = extensionLoader2.getExtension("black");
        URL url = new URL("http", "localhost", 8080); //代理逻辑
        url = url.addParameter("car", "red");
        person.getCar().color(url);
    }
}
