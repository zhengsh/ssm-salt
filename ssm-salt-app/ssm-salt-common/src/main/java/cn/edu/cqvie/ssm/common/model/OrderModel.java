package cn.edu.cqvie.ssm.common.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class OrderModel {

    /**
     * 订单号
     */
    private String orderCode;

    /**
     * 用户
     */
    @NotNull
    private Long userId;

    /**
     * 金额
     */
    @NotNull
    private BigDecimal amount;

}
