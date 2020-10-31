package cn.edu.cqvie.ssm.common.exception;

import cn.edu.cqvie.ssm.common.result.CommonResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@ControllerAdvice
public class WebException {

    @ExceptionHandler(ServiceException.class)
    public CommonResult<Void> handleServiceException(ServiceException e) {
        String message = e.getMessage();
        return CommonResult.error(message);
    }

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
