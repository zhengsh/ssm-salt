package cn.edu.cqvie.order.service;

import cn.edu.cqvie.order.dto.OrderDetailDto;
import cn.edu.cqvie.order.dto.OrderDto;

/**
 * 订单执行
 *
 * @author zhengsh
 * @date 2020-12-24
 */
public interface OrderService {

    /**
     * 订单创建
     *
     * @param dto
     * @return
     */
    OrderDetailDto createOrder(OrderDto dto);

    /**
     * 订单付款
     *
     * @return
     */
    OrderDetailDto paymentOrder(OrderDto dto);

    /**
     * 订单结算
     *
     * @return
     */
    OrderDetailDto settlementOrder(OrderDto dto);

    /**
     * 取消订单
     *
     * @param dto
     * @return
     */
    OrderDetailDto cancelOrder(OrderDto dto);
}
