package cn.edu.cqvie.ssm.common.result;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
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

    /**
     * 错误码
     */
    private String code = "200000";
    /**
     * 消息提示
     */
    private String message = "操作成功";
    /**
     * 返回数据
     */
    private List<T> list;
    /**
     * 总记录数
     */
    private Long total = 0L;

    /**
     * 查询列表成功
     *
     * @return 查询列表成功
     */
    public static PageableResult<Void> success() {
        return success(new ArrayList<>(), 0L);
    }

    /**
     * 查询列表成功
     *
     * @return 查询列表成功
     */
    public static <T> PageableResult<T> success(List<T> list, Long total) {
        PageableResult<T> result = new PageableResult<>();
        result.list = list;
        result.total = total;
        return result;
    }
}
