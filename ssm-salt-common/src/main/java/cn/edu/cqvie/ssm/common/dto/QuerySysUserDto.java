package cn.edu.cqvie.ssm.common.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * 查询系统用户
 *
 * @author zhengsh
 * @date 2020-10-22
 */
@Getter
@Setter
public class QuerySysUserDto extends PageableDto {
    private long id;

    private String username;

    private String password;

    private int age;

    private int sex;

    private String idCard;

    private String address;

    private Date birthday;
}
