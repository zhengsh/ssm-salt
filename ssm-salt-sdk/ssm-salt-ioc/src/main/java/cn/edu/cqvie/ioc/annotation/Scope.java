package cn.edu.cqvie.ioc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
<<<<<<< HEAD
 * Bean 懒加载
=======
 * ioc 是否单例
>>>>>>> 5038961aaa054814dd123428be2c38eedae461a4
 *
 * @author zhengsh
 * @date 2020-11-091
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Scope {
<<<<<<< HEAD
=======

>>>>>>> 5038961aaa054814dd123428be2c38eedae461a4
    String value() default "";
}
