package cn.edu.cqvie.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 服务降级重定向返回
 *
 * @author zhengsh
 * @date 2021-01-31
 */
@RestController
public class FallbackController {

    @GetMapping("/fallback")
    public Object login(ServerHttpResponse response) {
        response.setStatusCode(HttpStatus.GATEWAY_TIMEOUT);
        return "服务降级";
    }
}
