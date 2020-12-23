package cn.edu.cqvie.security.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

//@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    //@Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //"123456"
        //

        String pwd ="123456";
        return new User("zhengsh", passwordEncoder.encode(pwd),
                AuthorityUtils.commaSeparatedStringToAuthorityList("admin,user"));
    }

    //1. spring security 4.x 过后需要指定密码编码方式
    //2. PasswordEncoderFactories
    //3. 重写 #configure(AuthenticationManagerBuilder auth) 方法，实现 AuthenticationManager认 证管理器。

}
