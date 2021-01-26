package cn.edu.cqvie.jedis;

import redis.clients.jedis.Jedis;

import java.util.Arrays;

public class RedisLuaTest {

    public static void main(String[] args) {
        // 实现排他锁 demo
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        String key = "test:redis:lock";
        // 每个线程 value 不同，这里可以使用 uuid
        String val = "1000";
        String result = jedis.set(key, val, "nx", "px", 100000);
        if ("OK".equals(result)) {
            System.out.println("加锁成功: key = " + key + "; value=" + val);
        }
        // lua 脚本的使用
        Long count = (Long) jedis.eval("if redis.call(\"get\",KEYS[1]) == ARGV[1] then\n" +
                "    return redis.call(\"del\",KEYS[1])\n" +
                "else\n" +
                "    return 0\n" +
                "end", Arrays.asList(key), Arrays.asList(val));
        if (count == 1) {
            System.out.println("解锁成功: key = " + key + "; value=" + val);
        }
    }
}
