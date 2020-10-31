package cn.edu.cqvie.ssm.common.exception;

import cn.edu.cqvie.ssm.common.result.CommonResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Web 全局异常处理
 *
 * @author zhengsh
 * @date 2020-10-31
 */
@RestController
@ControllerAdvice
public class WebException {

    /**
     * 业务异常处理
     *
     * @param e 业务异常处理
     * @return 报文信息返回
     */
    @ExceptionHandler(ServiceException.class)
    public CommonResult<Void> handleServiceException(ServiceException e) {
        String message = e.getMessage();
        return CommonResult.error(message);
    }

    /**
     * 处理参数错误
     *
     * @param ex 参数校验异常
     * @return 报文信息返回
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public CommonResult<Void> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        List<FieldError> errors = bindingResult.getFieldErrors();
        String message = "";
        for (FieldError error : errors) {
            message = error.getDefaultMessage();
            break;
        }
        return CommonResult.error(message);
    }
}
