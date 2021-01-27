package cn.edu.cqvie.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RedisBitMapTest {

    public static void main(String[] args) throws IOException {
        // redis 位图
        Jedis jedis = new Jedis("127.0.0.1", 6379);

        //记录新闻订阅用户
        String key = "article:like:1001";
        Pipeline pp = jedis.pipelined();
        for (int offset = 1; offset <= 500000; offset++) {
            pp.setbit(key, offset, offset % 3 == 0);
        }
        pp.multi();
        pp.exec();
        pp.close();

        Long count = jedis.bitcount(key);
        System.out.println("key=" + key + "; count=" + count);

        //用户签到(不考虑数据持久化存储)
        int start = 20200101;
        int now = Integer.parseInt(new SimpleDateFormat("yyyyMMdd").format(new Date()));
        key = "user:sign:1001";
        int offset = now - start;
        for (int i = 0; i <= 365; i++) {
            jedis.setbit(key, i, String.valueOf((i % 3 == 0 ? 1 : 0)));
        }
        // 累计签到
        count = jedis.bitcount(key);
        System.out.println("用户: 1001 累计签到: " + count);

        // 是否签到
        Boolean isSign = jedis.getbit(key, offset);
        System.out.println("用户: 1001 " + now + " 是否签到: " + isSign);

        // 1 月份签到天数
        count = jedis.bitcount(key, 0, 30);
        System.out.println("用户: 1001 1 月份累计签到: " + count);

        // 输出结果
        // key=article:like:1001; count=333332
        // 用户: 1001 累计签到: 122
        // 用户: 1001 20210127 是否签到: false
        // 用户: 1001 1 月份累计签到: 83
    }
}
