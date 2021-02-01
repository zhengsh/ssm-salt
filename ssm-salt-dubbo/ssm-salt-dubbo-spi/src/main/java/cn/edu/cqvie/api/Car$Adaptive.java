package cn.edu.cqvie.api;

import org.apache.dubbo.common.extension.ExtensionLoader;

public class Car$Adaptive implements cn.edu.cqvie.api.Car {
    public java.lang.String color(org.apache.dubbo.common.URL arg0) {
        if (arg0 == null) throw new IllegalArgumentException("url == null");
        org.apache.dubbo.common.URL url = arg0;
        String extName = url.getParameter("car");
        if (extName == null)
            throw new IllegalStateException("Failed to get extension (cn.edu.cqvie.api.Car) name from url (" + url.toString() + ") use keys([car])");
        cn.edu.cqvie.api.Car extension = (cn.edu.cqvie.api.Car) ExtensionLoader.getExtensionLoader(cn.edu.cqvie.api.Car.class).getExtension(extName);
        return extension.color(arg0);
    }

    public void start() {
        throw new UnsupportedOperationException("The method public abstract void cn.edu.cqvie.api.Car.start() of interface cn.edu.cqvie.api.Car is not adaptive method!");
    }
}