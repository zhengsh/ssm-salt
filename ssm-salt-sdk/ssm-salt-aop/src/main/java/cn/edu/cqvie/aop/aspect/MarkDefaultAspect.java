package cn.edu.cqvie.aop.aspect;

import cn.edu.cqvie.aop.annotation.Mark;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Order(1000)
@Aspect
@Component
public class MarkDefaultAspect {

    @Pointcut("execution (* cn.edu.cqvie.aop.service..*.*(..))")
    public void doPointCut2() {
    }

    @Before("doPointCut2()")
    public void doBefore2(JoinPoint joinPoint) {
        System.out.println("doPointCut2 doPointCut2 doPointCut2");
    }
}
