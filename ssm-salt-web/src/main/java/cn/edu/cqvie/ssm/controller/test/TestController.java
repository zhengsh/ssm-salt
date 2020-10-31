package cn.edu.cqvie.ssm.controller.test;

import cn.edu.cqvie.ssm.common.dto.SysUserDto;
import cn.edu.cqvie.ssm.common.result.CommonResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("/star")
    public CommonResult<Void> star() {
        return CommonResult.success();
    }

}
