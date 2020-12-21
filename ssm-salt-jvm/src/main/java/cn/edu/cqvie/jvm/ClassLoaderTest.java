package cn.edu.cqvie.jvm;

import java.net.URL;
import java.net.URLClassLoader;

public class ClassLoaderTest {

    public static void main(String[] args) {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader().getParent();

        URLClassLoader urlClassLoader = (URLClassLoader) classLoader;

        URL[] urls = urlClassLoader.getURLs();
        for (URL url : urls) {
            System.out.println(url);
        }
    }
}
