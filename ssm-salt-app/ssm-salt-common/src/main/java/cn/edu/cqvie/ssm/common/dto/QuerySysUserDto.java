package cn.edu.cqvie.ssm.common.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
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
    /**
     * 数据库主键 id
     */
    private Long id;

    @Length(message = "500101", max = 20, min = 8)
    @NotNull(message = "500100")
    private String loginName;

    /**
     * 用户昵称
     */
    private String userName;

    /**
     * 用户类型（00系统用户 01注册用户）
     */
    private String userType;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 手机号码
     */
    private String phoneNumber;
}
