package cn.edu.cqvie.ssm.common.dto;

import lombok.Data;

/**
 * 通过ID查询
 *
 * @author zhengsh
 * @date 2020-10-22
 */
@Data
public class IdDto {

    private Long id;

    private Long[] ids;
}
