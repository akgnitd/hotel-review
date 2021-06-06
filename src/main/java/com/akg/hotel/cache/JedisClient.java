package com.akg.hotel.cache;

import redis.clients.jedis.JedisCluster;

public class JedisClient {

    private JedisCluster jedisCluster;

    public JedisClient(JedisCluster jedisCluster) {
        this.jedisCluster = jedisCluster;
    }

    public JedisCluster getJedisCluster() {
        return jedisCluster;
    }

    public void setJedisCluster(JedisCluster jedisCluster) {
        this.jedisCluster = jedisCluster;
    }
}
