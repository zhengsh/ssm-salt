package cn.edu.cqvie.ssm.controller.system;

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
        return CommonResult.success();
    }

    @PostMapping("/modify")
    public CommonResult<Void> modify(@RequestBody @Validated SysUserDto dto) {
        return CommonResult.success();
    }

    @PostMapping("/remove")
    public CommonResult<Void> remove(@RequestBody @Validated Long[] ids){
        return CommonResult.success();
    }

    @PostMapping("/get")
    public CommonResult<SysUserDto> findById(Long id){
        return userService.findById(id);
    }

    @PostMapping("/query")
    public PageableResult<SysUserDto> findAll(@RequestBody @Validated QuerySysUserDto dto) {
        return userService.findAll(dto);
    }
}
