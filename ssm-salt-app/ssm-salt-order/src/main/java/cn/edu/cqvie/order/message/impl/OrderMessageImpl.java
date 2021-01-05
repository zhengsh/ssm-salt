package cn.edu.cqvie.order.message.impl;

import cn.edu.cqvie.order.dto.OrderMessageDto;
import cn.edu.cqvie.order.message.OrderMessage;
import org.springframework.stereotype.Component;

@Component
public class OrderMessageImpl implements OrderMessage {

    @Override
    public void pushMessage(OrderMessageDto message) {

    }
}
