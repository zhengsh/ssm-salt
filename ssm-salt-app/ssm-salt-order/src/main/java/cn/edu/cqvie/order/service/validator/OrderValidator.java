package cn.edu.cqvie.order.service.validator;

import org.springframework.stereotype.Component;

/**
 * 订单校验器
 *
 * @author zhengsh
 * @date 202-12-20
 */
@Component
public class OrderValidator {

    public boolean userValidator() {
        return true;
    }
}
