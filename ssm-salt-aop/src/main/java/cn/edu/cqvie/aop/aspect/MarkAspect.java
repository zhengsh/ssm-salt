package cn.edu.cqvie.aop.aspect;

import cn.edu.cqvie.aop.annotation.Mark;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class MarkAspect {

    @Pointcut("@annotation(cn.edu.cqvie.aop.annotation.Mark) " +
            "|| @within(cn.edu.cqvie.aop.annotation.Mark)")
    public void doPointCut() {
    }

    @Before("doPointCut()")
    public void before(JoinPoint joinPoint) {
        try {
            Class<?> clazz = joinPoint.getTarget().getClass();
            String methodName = joinPoint.getSignature().getName();
            Method method = clazz.getMethod(methodName);
            Mark mark = method.getAnnotation(Mark.class);
            if (mark == null) {
                String targetName = clazz.getSimpleName();
                Class<?> targetClass = Class.forName(targetName);
                mark = targetClass.getAnnotation(Mark.class);
            }
            System.out.println("注解式拦截: " + mark.value());
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

}
