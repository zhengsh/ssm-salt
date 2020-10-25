package cn.edu.cqvie.ssm.common.result;

import lombok.Data;

/**
 * 默认返回
 *
 * @author zhengsh
 * @date 2020-10-22
 */
@Data
public class CommonResult<T> {
    private String code = "success";

    private String message;

    private T data;


    public static CommonResult<Void> error() {
        CommonResult<Void> result = new CommonResult<>();
        result.code = "error";
        result.message = "Operation error";
        return result;
    }

    public static CommonResult<Void> error(String message) {
        CommonResult<Void> result = new CommonResult<>();
        result.code = "error";
        result.message = message;
        return result;
    }

    public static CommonResult<Void> success() {
        CommonResult<Void> result = new CommonResult<>();
        result.message = "Operation succeeded";
        return result;
    }


    public static <T> CommonResult<T> success(T data) {
        CommonResult<T> result = new CommonResult<>();
        result.data = data;
        result.message = "Operation succeeded";
        return result;
    }
}
