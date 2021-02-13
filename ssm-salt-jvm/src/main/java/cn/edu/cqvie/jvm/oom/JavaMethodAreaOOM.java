package cn.edu.cqvie.jvm.oom;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

/**
 * -XX:MetaspaceSize=10m -XX:MaxMetaspaceSize=10m
 */
public class JavaMethodAreaOOM {

    public static void main(String[] args) {
        for (; ; ) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(JavaMethodAreaOOM.class);
            enhancer.setUseCache(false);
            enhancer.setCallback((MethodInterceptor) (obj, method, args1, proxy) ->
                    proxy.invoke(obj, args1));

            System.out.println("hello world");
            enhancer.create();
        }
    }
}