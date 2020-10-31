package cn.edu.cqvie.ssm.service;

import cn.edu.cqvie.ssm.common.dto.QuerySysUserDto;
import cn.edu.cqvie.ssm.common.dto.SysUserDto;
import cn.edu.cqvie.ssm.common.entity.SysUser;
import cn.edu.cqvie.ssm.common.result.CommonResult;
import cn.edu.cqvie.ssm.common.result.PageableResult;

/**
 * 系统用户
 *
 * @author zhengsh
 * @date 2020-10-25
 */
public interface SysUserService {

    CommonResult<Void> add(SysUserDto userDto);

    CommonResult<Void> modify(SysUserDto userDto);

    CommonResult<Void> remove(Long[] ids);

    CommonResult<SysUserDto> findById(Long id);

    PageableResult<SysUserDto> findAll(QuerySysUserDto dto);
}
