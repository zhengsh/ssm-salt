package cn.edu.cqvie.ssm.common.dto;

import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 系统用户
 *
 * @author zhengsh
 * @date 2020-10-22
 */
@Data
public class SysUserDto {

    private long id;

    @NotNull(message = "用户名不能为空")
    private String username;

    private String password;

    private int age;

    private int sex;

    private String idCard;

    private String address;

    private Date birthday;
}
