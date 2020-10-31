package cn.edu.cqvie.ssm.service;

import cn.edu.cqvie.ssm.common.dto.IdDto;
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

    /**
     * 添加
     *
     * @param dto 用户信息
     * @return 处理结果
     */
    CommonResult<Void> add(SysUserDto dto);

    /**
     * 修改
     *
     * @param dto 用户信息
     * @return 处理结果
     */
    CommonResult<Void> modify(SysUserDto dto);

    /**
     * 删除
     *
     * @param dto 用户信息
     * @return 处理结果
     */
    CommonResult<Void> remove(IdDto dto);

    /**
     * 通过 id 查询
     *
     * @param dto 用户信息
     * @return 处理结果
     */
    CommonResult<SysUserDto> get(IdDto dto);

    /**
     * 查询全部
     *
     * @param dto 用户信息
     * @return 处理结果
     */
    PageableResult<SysUserDto> query(QuerySysUserDto dto);
}
