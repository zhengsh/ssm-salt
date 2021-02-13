package cn.edu.cqvie.ssm.service;

import cn.edu.cqvie.ssm.common.model.OrderModel;
import cn.edu.cqvie.ssm.common.result.CommonResult;
import org.springframework.web.bind.annotation.RequestBody;

public interface OrderService {

    /**
     * 创建订单
     *
     * @param order
     * @return
     */
    CommonResult<OrderModel> create(OrderModel order);

    /**
     * 订单取消
     *
     * @param order
     * @return
     */
    CommonResult<OrderModel> cancel(OrderModel order);

    /**
     * 订单支付
     *
     * @param order
     * @return
     */
    CommonResult<OrderModel> payment(OrderModel order);

    /**
     * 查询详情
     *
     * @param order
     * @return
     */
    CommonResult<OrderModel> queryDetail(OrderModel order);
}
