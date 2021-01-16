package cn.edu.cqvie.mvc.controller;

import cn.edu.cqvie.mvc.dto.TestDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
public class TestController {

    @PostMapping("/test")
    @ResponseBody
    public TestDto test(@RequestBody TestDto dto) {
        return new TestDto();
    }

    @GetMapping("/")
    public String test1() {
        return "hello spring mvc";
    }
}
