package cn.edu.cqvie.ssm.controller.order;

import cn.edu.cqvie.ssm.common.model.OrderModel;
import cn.edu.cqvie.ssm.common.result.CommonResult;
import cn.edu.cqvie.ssm.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/createOrder")
    public CommonResult<OrderModel> create(@RequestBody OrderModel order) {
        return orderService.create(order);
    }
}
