package cn.edu.cqvie.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

public class RedisPipelineTest {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);

        // 使用管道
        long start = System.currentTimeMillis();
        Pipeline pipeline = jedis.pipelined();
        for (int i = 1; i <= 10000; i++) {
            pipeline.set("abc" + i, "i=" + i);
        }
        pipeline.multi();
        pipeline.exec();
        long end = System.currentTimeMillis();
        // 50ms
        System.out.println("pipeline cost time :" + (end - start) + "ms");


        jedis.resetState();
        start = System.currentTimeMillis();
        for (int i = 1; i <= 10000; i++) {
            jedis.set("abcd" + i, "i=" + i);
        }
        end = System.currentTimeMillis();
        //261ms
        System.out.println("pipeline cost time :" + (end - start) + "ms");
    }
}
