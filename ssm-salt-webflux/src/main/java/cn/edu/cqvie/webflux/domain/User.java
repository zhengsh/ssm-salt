package cn.edu.cqvie.webflux.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

/**
 * 用户信息实体类
 *
 * @author zhengsh
 * @date 2020-12-01
 */
@Data
@Table("user")
public class User {

    /**
     * id 主键
     */
    @Id
    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别：1男，0女
     */
    private Short sex;

    /**
     * 出生日期
     */
    private LocalDate birthday;
}
