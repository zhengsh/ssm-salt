package cn.edu.cqvie.ssm.service;

import cn.edu.cqvie.ssm.Application;
import cn.edu.cqvie.ssm.common.dto.QuerySysUserDto;
import cn.edu.cqvie.ssm.common.dto.SysUserDto;
import cn.edu.cqvie.ssm.common.result.CommonResult;
import cn.edu.cqvie.ssm.common.result.PageableResult;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@DisplayName("测试-系统用户管理")
@Slf4j
@ExtendWith(SpringExtension.class) //导入spring测试框架
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)//按@Order指定顺序执行
@SpringBootTest(classes = {Application.class}, webEnvironment = SpringBootTest.WebEnvironment.NONE)
class SysUserServiceTest {

    @Autowired
    private SysUserService userService;

    private static long id = 100;

    @Order(1)
    @DisplayName("测试-系统用户管理新增")
    @Test
    void add() {
        SysUserDto sysUserDto = new SysUserDto();
        sysUserDto.setId(id);
        sysUserDto.setUsername("zhangsan");
        CommonResult<Void> result = userService.add(sysUserDto);
        id = sysUserDto.getId();
        log.info("add user:{}", sysUserDto);
        log.info("add result:{}", result);
    }

    @DisplayName("测试-系统用户管理ID修改")
    @Order(2)
    @Test
    void modify() {
        SysUserDto sysUserDto = new SysUserDto();
        sysUserDto.setId(id);
        sysUserDto.setUsername("zhangsan");
        CommonResult<Void> result = userService.modify(sysUserDto);
        log.info("modify user :{}", sysUserDto);
        log.info("modify result :{}", result);
    }

    @DisplayName("测试-系统用户管理ID查询")
    @Order(3)
    @Test
    void findById() {
        CommonResult<SysUserDto> result = userService.findById(id);
        log.info("findById result :{}", result);
    }


    @Order(4)
    @DisplayName("测试-系统用户管理查询")
    @Test
    void findAll() {
        QuerySysUserDto dto = new QuerySysUserDto();
        dto.setUsername("z");
        PageableResult<SysUserDto> result = userService.findAll(dto);
        log.info("page result :{}", result);
    }

    @DisplayName("测试-系统用户管理删除")
    @Order(5)
    @Test
    void remove() {
        CommonResult<Void> result = userService.remove(new Long[]{id});
        log.info("remove result :{}", result);
    }
}
