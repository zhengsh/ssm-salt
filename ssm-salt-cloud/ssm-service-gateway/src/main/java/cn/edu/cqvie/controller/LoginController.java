package cn.edu.cqvie.controller;

import org.springframework.http.ResponseCookie;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Mock 登录接口
 *
 * @author zhengsh
 * @date 2021-01-31
 */
@RestController
public class LoginController {

    @GetMapping("/login")
    public Object login(ServerHttpResponse response) {
        response.addCookie(ResponseCookie.from("login", "user-1").build());
        return "ok";
    }
}
