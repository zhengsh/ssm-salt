package cn.edu.cqvie.ssm.service.impl;

import cn.edu.cqvie.ssm.common.dto.QuerySysUserDto;
import cn.edu.cqvie.ssm.common.dto.SysUserDto;
import cn.edu.cqvie.ssm.common.entity.SysUser;
import cn.edu.cqvie.ssm.common.exception.ServiceException;
import cn.edu.cqvie.ssm.common.result.CommonResult;
import cn.edu.cqvie.ssm.common.result.PageableResult;
import cn.edu.cqvie.ssm.dao.SysUserDao;
import cn.edu.cqvie.ssm.service.SysUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cn.edu.cqvie.ssm.common.utils.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 系统用户
 *
 * @author zhengsh
 * @date 2020-10-22
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private SysUserDao userDao;

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public CommonResult<Void> add(SysUserDto userDto) {
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(userDto, sysUser);
        int row = userDao.insert(sysUser);
        if (row < 1) {
            throw new ServiceException("sql insert error");
        }
        userDto.setId(sysUser.getId());
        return CommonResult.success(null);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public CommonResult<Void> modify(SysUserDto userDto) {
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(userDto, sysUser);
        int update = userDao.update(sysUser);
        if (update < 1) {
            throw new ServiceException("sql update error");
        }
        return CommonResult.success();
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public CommonResult<Void> remove(Long[] ids) {
        int delete = userDao.delete(ids);
        if (delete < 1) {
            throw new ServiceException("sql delete error");
        }
        return CommonResult.success();
    }

    @Override
    public CommonResult<SysUserDto> findById(Long id) {
        SysUser user = userDao.findById(id);
        SysUserDto userDto = new SysUserDto();
        if (user != null) {
            BeanUtils.copyProperties(user, userDto);
        }
        return CommonResult.success(userDto);
    }

    @Override
    public PageableResult<SysUserDto> findAll(QuerySysUserDto dto) {
        PageHelper.startPage(dto.getIndex(), dto.getLimit());
        List<SysUser> userList = userDao.findAll(dto);
        PageInfo<SysUser> p = new PageInfo<>(userList);
        return PageableResult.success(BeanUtils.copyListProperties(p.getList(), SysUserDto::new), p.getTotal());
    }
}
