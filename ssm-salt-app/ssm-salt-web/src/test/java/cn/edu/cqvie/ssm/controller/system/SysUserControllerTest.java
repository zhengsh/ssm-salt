package cn.edu.cqvie.ssm.controller.system;

import cn.edu.cqvie.ssm.Application;
import cn.edu.cqvie.ssm.common.dto.SysUserDto;
import cn.edu.cqvie.ssm.service.SysUserService;
import com.alibaba.fastjson.JSON;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import java.nio.charset.Charset;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@DisplayName("测试-系统用户管理")
@Slf4j
@ExtendWith(SpringExtension.class) //导入spring测试框架
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)//按@Order指定顺序执行
@AutoConfigureMockMvc
@SpringBootTest(classes = {Application.class}, webEnvironment = SpringBootTest.WebEnvironment.MOCK)
class SysUserControllerTest {

    @Autowired
    private MockMvc mockMvc;
    //@MockBean
    //private SysUserService userService;

    @SneakyThrows
    @DisplayName("测试-系统用户管理添加用户")
    @Order(1)
    @Test
    void add() {
        SysUserDto dto = new SysUserDto();
        dto.setLoginName("HuaWei");
        dto.setAvatar("这个是一个头像的地址，。。。🏷");

        ResultActions resultAction = mockMvc.perform(
                post("/sys/user/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JSON.toJSONString(dto)));
        resultAction.andReturn().getResponse().setCharacterEncoding("UTF-8");
        //添加断言
        resultAction.andDo(print()).andExpect(status().isOk());
    }

    @Test
    void modify() {
    }

    @Test
    void remove() {
    }

    @Test
    void get() {
    }

    @Test
    void query() {
    }
}
