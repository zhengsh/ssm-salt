package cn.edu.cqvie.order.service;

import cn.edu.cqvie.order.dto.OrderDetailDto;

import java.util.List;

/**
 * 订单执行
 *
 * @author zhengsh
 * @date 2020-12-24
 */
public interface QueryOrderService {

    /**
     * 订单列表
     *
     * @return
     */
    List<OrderDetailDto> queryOrderList();

    /**
     * 订单详情
     *
     * @return
     */
    List<OrderDetailDto> queryOrderDetail();
}
