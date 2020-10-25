package cn.edu.cqvie.ssm.common.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 业务异常
 *
 * @author ZAKJ_ASUS
 */
@Data
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
