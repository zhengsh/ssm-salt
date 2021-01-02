package cn.edu.cqvie.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @RequestMapping("/main")
    public String main() {
        return "redirect:/main.html";
    }

    @RequestMapping("/toerror")
    public String error() {
        return "redirect:/error.html";
    }
}