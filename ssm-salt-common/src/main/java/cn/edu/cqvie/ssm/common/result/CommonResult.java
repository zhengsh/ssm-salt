package cn.edu.cqvie.ssm.common.result;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 默认返回
 *
 * @author zhengsh
 * @date 2020-10-22
 */
@Getter
@Setter
public class CommonResult<T> {

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
    private T data;

    /**
     * 操作失败
     *
     * @return 返回公共结构
     */
    public static CommonResult<Void> error() {
        return error("500000", "失败");
    }

    /**
     * 操作失败
     *
     * @param message 消息内容
     * @return 返回公共结构
     */
    public static CommonResult<Void> error(String message) {
        return error("500000", message);
    }

    /**
     * 操作失败
     *
     * @param code    错误码
     * @param message 消息内容
     * @return 返回公共结构
     */
    public static CommonResult<Void> error(String code, String message) {
        CommonResult<Void> result = new CommonResult<>();
        result.code = code;
        result.message = message;
        return result;
    }


    /**
     * 操作成功
     *
     * @return 返回公共结构
     */
    public static CommonResult<Void> success() {
        return success(null);
    }

    /**
     * 操作成功
     *
     * @param data 结果数据对象
     * @return 返回公共结构
     */
    public static <T> CommonResult<T> success(T data) {
        CommonResult<T> result = new CommonResult<>();
        result.data = data;
        return result;
    }


}
