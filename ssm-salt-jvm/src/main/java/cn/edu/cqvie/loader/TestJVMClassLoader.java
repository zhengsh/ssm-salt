package cn.edu.cqvie.loader;

import com.sun.crypto.provider.DESKeyFactory;
import sun.misc.Launcher;

import java.net.URL;

public class TestJVMClassLoader {

    public static void main(String[] args) {
        System.out.println(String.class.getClassLoader());
        System.out.println(DESKeyFactory.class.getClassLoader());
        System.out.println(TestJVMClassLoader.class.getClassLoader());

        System.out.println();
        ClassLoader appClassLoader = ClassLoader.getSystemClassLoader();
        ClassLoader extClassLoader = appClassLoader.getParent();
        ClassLoader bootstrapClassLoader = extClassLoader.getParent();

        System.out.println("bootstrapClassLoader: " + bootstrapClassLoader);
        System.out.println("extClassLoader: " + extClassLoader);
        System.out.println("appClassLoader: " + appClassLoader);

        System.out.println();
        System.out.println("bootstrapLoader 加载以下文件：");
        URL[] urls = Launcher.getBootstrapClassPath().getURLs();
        for (URL url : urls) {
            System.out.println(url);
        }

        System.out.println();
        System.out.println("extClassLoader 加载以下文件：");
        System.out.println(System.getProperty("java.ext.dirs"));

        System.out.println();
        System.out.println("appClassLoader 加载以下文件：");
        System.out.println(System.getProperty("java.class.path"));


    }

}
