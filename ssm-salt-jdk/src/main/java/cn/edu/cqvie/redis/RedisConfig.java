package cn.edu.cqvie.redis;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.*;

import java.time.Duration;

@Configuration
public class RedisConfig {

    private final String ChannelOne = "ChannelOne";

    private final String ChannelTwo = "ChannelTwo";

    //Key的过期时间
    private Duration timeToLive = Duration.ofDays(1);

    /**
     * redis模板，存储关键字是字符串，值jackson2JsonRedisSerializer是序列化后的值
     *
     * @param
     * @return org.springframework.data.redis.core.RedisTemplate
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(connectionFactory);
        //使用Jackson2JsonRedisSerializer来序列化和反序列化redis的value值（默认使用JDK的序列化方式）
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);

        //使用StringRedisSerializer来序列化和反序列化redis的key值
        RedisSerializer redisSerializer = new StringRedisSerializer();
        //key
        redisTemplate.setKeySerializer(redisSerializer);
        redisTemplate.setHashKeySerializer(redisSerializer);
        //value
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);

        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

    @Bean
    public RedisCacheConfiguration redisCacheConfiguration() {
        return RedisCacheConfiguration.
                defaultCacheConfig().
                entryTtl(this.timeToLive).			//Key过期时间 此处设置1天
                serializeKeysWith(RedisSerializationContext.SerializationPair.
                fromSerializer(new StringRedisSerializer())).
                serializeValuesWith(RedisSerializationContext.SerializationPair.
                        fromSerializer(new GenericJackson2JsonRedisSerializer()));
    }

    /**
     * Redis订阅消息监听器
     *
     * @param connectionFactory
     * @param channelOneAdapter
     * @param channelTwoAdapter
     * @return
     */
    @Bean
    public RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory, MessageListenerAdapter channelOneAdapter, MessageListenerAdapter channelTwoAdapter) {
        RedisMessageListenerContainer listenerContainer = new RedisMessageListenerContainer();
        listenerContainer.setConnectionFactory(connectionFactory);
        //监听频道1
        listenerContainer.addMessageListener(channelOneAdapter, new PatternTopic(ChannelOne));
        //监听频道2
        listenerContainer.addMessageListener(channelTwoAdapter, new PatternTopic(ChannelTwo));
        return listenerContainer;
    }

    /**
     * 委托对象 当我们监听的频道1 有新消息到来时，使用defaultListenerMethod来处理订阅的消息
     * 此处springboot利用反射的技术，使用defaultListenerMethod处理消息
     * @param processMessagesChannelOne
     * @return
     */
    @Bean
    public MessageListenerAdapter channelOneAdapter(ProcessMessagesChannelOne processMessagesChannelOne) {
        return new MessageListenerAdapter(processMessagesChannelOne, "monitorBroadcast");
    }

    /**
     * 委托对象 当我们监听的频道2 有新消息到来时，使用defaultListenerMethod来处理订阅的消息
     * 此处springboot利用反射的技术，使用defaultListenerMethod处理消息
     * @param processMessagesChannelTwo
     * @return
     */
    @Bean
    public MessageListenerAdapter channelTwoAdapter(ProcessMessagesChannelTwo processMessagesChannelTwo) {
        return new MessageListenerAdapter(processMessagesChannelTwo, "monitorBroadcast");
    }
}
