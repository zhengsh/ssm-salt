package cn.edu.cqvie.aop.aspect;

import cn.edu.cqvie.aop.annotation.Mark;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@Aspect
@Component
public class MarkAspect {

    @Pointcut("@annotation(cn.edu.cqvie.aop.annotation.Mark) " +
            "|| @within(cn.edu.cqvie.aop.annotation.Mark)")
    public void doPointCut() {
    }

    @Before("doPointCut()")
    public void before(JoinPoint joinPoint) throws ClassNotFoundException {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Mark mark = method.getAnnotation(Mark.class);
        if (mark == null) {
            String targetName = joinPoint.getTarget().getClass().getName();
            Class targetClass = Class.forName(targetName);
            Annotation annotation = targetClass.getAnnotation(Mark.class);
            mark = (Mark) annotation;
        }
        System.out.println("注解式拦截 " + mark.value());
    }

}
