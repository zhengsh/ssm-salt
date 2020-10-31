package cn.edu.cqvie.ssm.common.result;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 翻页返回
 *
 * @author zhengsh
 * @date 2020-10-22
 */
@Getter
@Setter
public class PageableResult<T> {

    private String code = "success";

    private String message;

    private List<T> list;

    private Long total = 0L;

    public static PageableResult<Void> success() {
        PageableResult<Void> result = new PageableResult<>();
        result.message = "Operation succeeded";
        return result;
    }

    public static <T> PageableResult<T> success(List<T> list, Long total) {
        PageableResult<T> result = new PageableResult<>();
        result.list = list;
        result.total = total;
        result.message = "Operation succeeded";
        return result;
    }
}
