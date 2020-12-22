package cn.edu.cqvie.aop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@Configuration
@ComponentScan({"cn.edu.cqvie.aop.aspect", "cn.edu.cqvie.aop.service.impl"})
public class AopConfig {

}
