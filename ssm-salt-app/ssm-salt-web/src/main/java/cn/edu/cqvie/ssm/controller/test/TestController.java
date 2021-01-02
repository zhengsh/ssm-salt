package cn.edu.cqvie.ssm.controller.test;

import cn.edu.cqvie.ssm.common.result.CommonResult;
import org.springframework.web.bind.annotation.*;

/**
 * 测试代码
 *
 * @author zhengsh
 * @date 2020-10-31
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("/star")
    public CommonResult<Void> star() {
        return CommonResult.success();
    }

}
