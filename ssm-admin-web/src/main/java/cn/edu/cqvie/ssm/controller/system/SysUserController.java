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
    public CommonResult<Void> add(@RequestBody @Validated SysUserDto dto) {
        return userService.add(dto);
    }

    @PostMapping("/modify")
    public CommonResult<Void> modify(@RequestBody @Validated SysUserDto dto) {
        return userService.modify(dto);
    }

    @PostMapping("/remove")
    public CommonResult<Void> remove(@RequestBody @Validated IdDto dto) {
        return userService.remove(dto.getIds());
    }

    @PostMapping("/get")
    public CommonResult<SysUserDto> get(@RequestBody @Validated IdDto dto) {
        return userService.findById(dto.getId());
    }

    @PostMapping("/query")
    public PageableResult<SysUserDto> query(@RequestBody @Validated QuerySysUserDto dto) {
        return userService.findAll(dto);
    }
}
