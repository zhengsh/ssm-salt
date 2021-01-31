package cn.edu.cqvie.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

/**
 * 自定义登录过滤器判断是否登录
 *
 * @author zhengsh
 * @date 2021-01-31
 */
public class LoginFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        MultiValueMap<String, HttpCookie> cookies = exchange.getRequest().getCookies();
        for (Map.Entry<String, List<HttpCookie>> cookie : cookies.entrySet()) {
            // 如果 cookie 中包含 login 信息就表示通过
            if (cookie.getKey().equals("login")) {
                System.out.println(1);
                return chain.filter(exchange);
            }
        }
        System.out.println(2);
        // 401
        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(HttpStatus.UNAUTHORIZED);
        return response.setComplete();
    }


    @Override
    public int getOrder() {
        return -1;
    }
}
