package cn.edu.cqvie.ioc;

import cn.edu.cqvie.ioc.annotation.ComponentScan;

import java.io.File;
import java.net.URL;

/**
 * ioc 启动类
 *
 * @author zhengsh
 * @date 2020-11-091
 */
public class IocApplicationContext {

    private Class configClass;

    public IocApplicationContext(Class configClass) {
        this.configClass = configClass;

        //扫描
        if (configClass.isAnnotationPresent(ComponentScan.class)) {
            ComponentScan componentScanAnnotation = (ComponentScan) configClass.getAnnotation(ComponentScan.class);
            String path = componentScanAnnotation.value();//扫描路径： cn.edu.cqvie.ioc.service
            path = path.replace(".", "/");
            System.out.println(path);

            ClassLoader classLoader = IocApplicationContext.class.getClassLoader();
            URL resource = classLoader.getResource(path);
            File file = new File(resource.getFile());
            for (File listFile : file.listFiles()){
                System.out.println(listFile);
            }
        }
    }

    /**
     * 通过 BeanName 获取 Bean 实例
     * @param beanName
     * @return
     */
    public Object getBean(String beanName) {
        return null;
    }

}
