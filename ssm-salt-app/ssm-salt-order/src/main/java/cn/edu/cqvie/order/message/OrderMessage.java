package cn.edu.cqvie.order.message;

import cn.edu.cqvie.order.dto.OrderMessageDto;
import org.springframework.stereotype.Component;

public interface OrderMessage {

    void pushMessage(OrderMessageDto message);
}
