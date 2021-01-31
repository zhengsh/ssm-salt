package cn.edu.cqvie.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/integral")
public class IntegralController {

    @Value("${server.port}")
    private Integer port;

    @GetMapping("/test")
    public String test() {
        return "ok; port:" + port;
    }
}
