package cn.edu.cqvie.ssm.common.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * 分页入参基类
 *
 * @author zhengsh
 * @date 2020-10-22
 */
@Getter
@Setter
public class PageableDto {
    /**
     * 当前页
     */
    private int index = 1;
    /**
     * 每页显示记录数
     */
    private int limit = 10;
}
