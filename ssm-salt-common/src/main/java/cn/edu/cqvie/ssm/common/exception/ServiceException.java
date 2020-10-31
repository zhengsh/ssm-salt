package cn.edu.cqvie.ssm.common.exception;

import lombok.*;

/**
 * 业务异常
 *
 * @author ZAKJ_ASUS
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServiceException extends RuntimeException {

    private String code;
    private String message;

    public ServiceException(String message) {
        this.message = message;
    }
}
