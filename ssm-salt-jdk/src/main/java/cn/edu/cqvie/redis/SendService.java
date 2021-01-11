package cn.edu.cqvie.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class SendService {
    @Autowired
    private RedisTemplate redisTemplate;

    public String send() {
        redisTemplate.opsForList().leftPush("queue:queueData", "既然被你看到了我，那我就要和程序世界说再见了哦!");
        return "ok";
    }
}
