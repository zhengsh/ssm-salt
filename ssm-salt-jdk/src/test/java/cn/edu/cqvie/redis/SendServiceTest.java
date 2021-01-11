package cn.edu.cqvie.redis;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

//导入spring测试框架
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {Application.class},
        webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class SendServiceTest {

    @Autowired
    private SendService sendService;

    @Test
    public void send() {
        String result = sendService.send();
        Assertions.assertEquals("ok", result);
    }
}