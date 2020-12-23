package cn.edu.cqvie.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author zhengsh
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    //1. spring security 4.x 过后需要指定密码编码方式
    //2. PasswordEncoderFactories
    //3. userDetailsServiceBean 定义
    //3. 重写 #configure(AuthenticationManagerBuilder auth) 方法，实现 AuthenticationManager认 证管理器。


    /**
     * 定义加密方式
     *
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);

        String password = passwordEncoder().encode("123456");
        auth
                // 使用基于内存的 InMemoryUserDetailsManager
                .inMemoryAuthentication()
                // 使用 PasswordEncoder 密码编码器
                .passwordEncoder(passwordEncoder())
                // 配置用户
                .withUser("zhengsh").password(password).roles("admin")
                // 配置其他用户
                .and().withUser("zhengsh2").password(password).roles("user");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http.formLogin() //表单登录
                .loginPage("/login.html") //自定义登录页面
                .loginProcessingUrl("/user/login") //登录访问路径，必须和表单提交接口一样
                .defaultSuccessUrl("/admin/index") //认证成功之后跳转的路径

                //设置哪些路径可以直接访问，不需要认证
                .and().authorizeRequests()
                .antMatchers("/user/login", "/login.html")
                .permitAll()
                .anyRequest()
                .authenticated() //需要认证
                .and().csrf().disable(); //关闭csrf防护
    }

//    @Bean
//    @Override
//    public UserDetailsService userDetailsServiceBean() throws Exception {
//        return super.userDetailsServiceBean();
//    }


}
