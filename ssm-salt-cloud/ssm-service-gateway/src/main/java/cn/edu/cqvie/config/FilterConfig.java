package cn.edu.cqvie.config;

import cn.edu.cqvie.filter.LoginFilter;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 过滤器配置（举例：登录检查过滤器）
 *
 * @author zhengsh
 * @date 2021-01-31
 */
@Configuration
public class FilterConfig {

    @Bean
    public GlobalFilter loginFilter() {
        return new LoginFilter();
    }
}
