package cn.edu.cqvie.ssm.service.impl;

import cn.edu.cqvie.ssm.common.exception.ServiceException;
import cn.edu.cqvie.ssm.common.model.OrderModel;
import cn.edu.cqvie.ssm.common.result.CommonResult;
import cn.edu.cqvie.ssm.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public CommonResult<OrderModel> create(OrderModel order) {
        // 1. 规则判断
        if (order.getAmount().intValue() < 10) {
            throw new ServiceException("amount must > 10");
        }

        // 2. 构造对象
        order.setOrderCode("CRO" + System.currentTimeMillis());


        return null;
    }

    @Override
    public CommonResult<OrderModel> cancel(OrderModel order) {
        return null;
    }

    @Override
    public CommonResult<OrderModel> payment(OrderModel order) {
        return null;
    }

    @Override
    public CommonResult<OrderModel> queryDetail(OrderModel order) {
        return null;
    }
}
