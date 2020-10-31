package cn.edu.cqvie.ssm.common.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

/**
 * 系统用户
 *
 * @author zhengsh
 * @date 2020-10-22
 */
@Getter
@Setter
public class SysUserDto {

    /**
     * 主键 id
     */
    private Long id;
    /**
     * 部门ID
     */
    private Long deptId;

    /**
     * 登录账号
     */
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

    /**
     * 用户性别（0男 1女 2未知）
     */
    private String sex;

    /**
     * 头像路径
     */
    private String avatar;

    /**
     * 密码
     */
    private String password;

    /**
     * 盐加密
     */
    private String salt;

    /**
     * 帐号状态（0正常 1停用）
     */
    private String status;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    private String delFlag;

    /**
     * 最后登录IP
     */
    private String loginIp;

    /**
     * 最后登录时间
     */
    private LocalDate loginDate;

    /**
     * 密码最后更新时间
     */
    private LocalDate pwdUpdateDate;

    /**
     * 创建者
     */
    private String createBy;

    /**
     * 创建时间
     */
    private LocalDate createTime;

    /**
     * 更新者
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private LocalDate updateTime;

    /**
     * 备注
     */
    private String remark;

}
