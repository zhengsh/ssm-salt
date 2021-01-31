package cn.edu.cqvie.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/member")
public class MemberController {

    @Value("${server.port}")
    private Integer port;

    @GetMapping("/test")
    public String test() throws InterruptedException {
        Random random = new Random();
        int time = random.nextInt(10);
        TimeUnit.SECONDS.sleep(time);
        return "ok; port:" + port;
    }
}
