package cn.edu.cqvie.ssm.common.exception;

import lombok.*;

/**
 * 业务异常
 *
 * @author zhengsh
 * @date 2020-10-31
 */
@Getter
@Setter
public class ServiceException extends RuntimeException {

    private String code;
    private String message;

    public ServiceException(String message) {
        this.code = "";
        this.message = message;
    }

    public ServiceException(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
