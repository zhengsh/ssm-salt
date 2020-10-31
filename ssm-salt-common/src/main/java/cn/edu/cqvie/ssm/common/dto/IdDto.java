package cn.edu.cqvie.ssm.common.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * 通过ID查询
 *
 * @author zhengsh
 * @date 2020-10-22
 */
@Getter
@Setter
public class IdDto {

    /**
     * 数据库主键 id
     */
    private Long id;

    /**
     * 数据库主键 id 数组
     */
    private Long[] ids;
}
