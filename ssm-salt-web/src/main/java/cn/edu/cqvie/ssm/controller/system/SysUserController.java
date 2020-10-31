package cn.edu.cqvie.ssm.controller.system;

import cn.edu.cqvie.ssm.common.dto.IdDto;
import cn.edu.cqvie.ssm.common.dto.QuerySysUserDto;
import cn.edu.cqvie.ssm.common.dto.SysUserDto;
import cn.edu.cqvie.ssm.common.result.CommonResult;
import cn.edu.cqvie.ssm.common.result.PageableResult;
import cn.edu.cqvie.ssm.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 系统用户
 *
 * @author zhengsh
 * @date 2020-10-25
 */
@RestController
@RequestMapping("/sys/user")
public class SysUserController {

    @Autowired
    private SysUserService userService;

    @PostMapping("/add")
    public CommonResult<Void> add(@RequestBody SysUserDto dto) {
        return userService.add(dto);
    }

    @PostMapping("/modify")
    public CommonResult<Void> modify(@RequestBody SysUserDto dto) {
        return userService.modify(dto);
    }

    @PostMapping("/remove")
    public CommonResult<Void> remove(@RequestBody IdDto dto) {
        return userService.remove(dto);
    }

    @PostMapping("/get")
    public CommonResult<SysUserDto> get(@RequestBody IdDto dto) {
        return userService.get(dto);
    }

    @PostMapping("/query")
    public PageableResult<SysUserDto> query(@RequestBody QuerySysUserDto dto) {
        return userService.query(dto);
    }
}
