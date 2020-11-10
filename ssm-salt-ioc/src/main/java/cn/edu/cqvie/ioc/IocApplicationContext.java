package cn.edu.cqvie.ioc;

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
