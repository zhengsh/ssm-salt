package cn.edu.cqvie.manger;

import cn.edu.cqvie.cache.LocalCache;
import cn.edu.cqvie.dao.UserDao;
import cn.edu.cqvie.model.UserModel;
import cn.edu.cqvie.redis.NullValue;

/**
 * @author zhengsh
 */
public class UserManager {
    UserDao userDao;
    LocalCache localCache;

    public String getKey(String key) throws InterruptedException {
        String value = redis.get(key);
        if (value == null) {
            //设置互斥锁的key
            String mutexKey = "mutex:key:" + key;
            //给这个key上一把锁，ex表示只有一个线程能执行，过期时间为180秒
            if (redis.set(mutexKey, "1", "ex 180", "nx")) {
                value = db.get(key);
                redis.set(key, value);
                redis.delete(mutexKety);
            } else {
                //其他的线程休息100毫秒后重试
                Thread.sleep(100);
                getKey(key);
            }
        }
        return value;
    }


    public UserModel getUser(String userNick) {
        Object object = localCache.get(userNick);
        if (object != null) {
            if (object instanceof NullValue) {
                return null;
            }
            return (UserModel) object;
        } else {
            UserModel user = userDao.getUser(userNick);
            if (user != null) {
                localCache.put(userNick, user);
            } else {
                localCache.put(userNick, new NullValue());
            }
            return user;
        }
    }
}
