package cn.edu.cqvie.ssm.service.impl;

import cn.edu.cqvie.ssm.common.exception.ServiceException;
import cn.edu.cqvie.ssm.common.model.OrderModel;
import cn.edu.cqvie.ssm.common.result.CommonResult;
import cn.edu.cqvie.ssm.dao.OrderDao;
import cn.edu.cqvie.ssm.service.OrderService;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Resource
    private OrderDao orderDao;

    private static final String ORDER_KEY_FMT = "salt:order:%s";
    private static final String ORDER_LOCK_KEY_FMT = "salt:order:lock:%s";


    @Override
    public CommonResult<OrderModel> create(OrderModel order) {
        // 1. 规则判断
        if (order.getAmount().intValue() < 10) {
            throw new ServiceException("amount must > 10");
        }

        // 2. 构造对象
        String orderCode = "CRO" + System.currentTimeMillis();
        order.setOrderCode(orderCode);


        return null;
    }

    @Override
    public CommonResult<OrderModel> cancel(OrderModel order) {
        return null;
    }

    @Override
    public CommonResult<OrderModel> payment(OrderModel order) {
        // 1. 更新数据

        // 2. 删除缓存
        String key = String.format(ORDER_KEY_FMT, order.getOrderCode());
        redisTemplate.delete(key);
        return CommonResult.success(new OrderModel());
    }

    @Override
    public CommonResult<OrderModel> queryDetail(OrderModel order) {
        // 1. 查询缓存数据
        String key = String.format(ORDER_KEY_FMT, order.getOrderCode());
        String val = redisTemplate.opsForValue().get(key);
        if (val != null && !"".equals(val.trim())) {
            OrderModel model = JSONObject.parseObject(val, OrderModel.class);
            if (model != null) {
                // 如果查询到了缓存直接返回
                return CommonResult.success(model);
            }
        }
        // 2. 缓存数据没有拿到

        return CommonResult.success(new OrderModel());
    }
}
