package com.akg.hotel.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisCluster;

@Component
public class RedisClusterClient {

    private static RedisClusterClient store = new RedisClusterClient();

    @Autowired
    private JedisClient jedisClient;

    private JedisCluster instance() {
        return jedisClient.getJedisCluster();
    }

    public static RedisClusterClient getInstance() {
        return store;
    }

    public String fetch(String key) {
        return instance().get(key);
    }

    public void store(String key, String value) {
        instance().set(key, value);
    }

    public Long delete(String key) {
        return instance().del(key);
    }

    public void store(String key, byte[] fileContent) {
        instance().set(key.getBytes(), fileContent);
    }

    public boolean exists(String key) {
        return instance().exists(key);
    }

    public byte[] fetch(byte[] key) {
        return instance().get(key);
    }

    public Long delete(byte[] key) {
        return instance().decr(key);
    }

    public void serExpire(String key, Integer seconds) {
        instance().expire(key.getBytes(), seconds);
    }
}
