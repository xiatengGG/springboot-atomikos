package com.xiateng.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * jedis获取工具类
 */
public class JedisUtil {

    private static JedisPool jedisPool;
    private static final Logger logger = LoggerFactory.getLogger(JedisUtil.class);

    static {
        // 初始化连接池
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(20);
        jedisPoolConfig.setMaxIdle(10);
        jedisPool = new JedisPool(jedisPoolConfig, "127.0.0.1", 6379);
        logger.info("jedisPool连接池初始化====" + jedisPool);
    }

    /**
     * 获取一个Jedis实例
     * @return
     */
    public synchronized static Jedis getJedis(){
        Jedis jedis = jedisPool.getResource();
//        jedis.auth("123456");//密码
        return jedis;
    }
}
