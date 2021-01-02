package cn.edu.cqvie.order.service.impl;

import cn.edu.cqvie.order.dto.OrderDetailDto;
import cn.edu.cqvie.order.dto.OrderDto;
import cn.edu.cqvie.order.message.OrderMessage;
import cn.edu.cqvie.order.service.OrderService;
import cn.edu.cqvie.order.service.validator.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 订单执行抽象类
 *
 * @author zhengsh
 * @date 2020-12-24
 */
@Component
public abstract class AbstractOrderService implements OrderService {

    @Autowired
    protected OrderValidator orderValidator;
    @Autowired
    protected OrderMessage orderMessage;

    @Override
    public OrderDetailDto createOrder(OrderDto dto) {
        return null;
    }

    @Override
    public OrderDetailDto paymentOrder(OrderDto dto) {
        return null;
    }

    @Override
    public OrderDetailDto settlementOrder(OrderDto dto) {
        return null;
    }

    @Override
    public OrderDetailDto cancelOrder(OrderDto dto) {
        return null;
    }
}
