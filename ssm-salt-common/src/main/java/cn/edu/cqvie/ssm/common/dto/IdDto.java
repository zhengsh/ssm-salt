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

    private Long id;

    private Long[] ids;
}
