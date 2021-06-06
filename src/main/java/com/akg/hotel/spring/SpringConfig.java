package com.akg.hotel.spring;

import com.akg.hotel.cache.JedisClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableAspectJAutoProxy
public class SpringConfig {

    @Bean
    public JedisClient jedisClient() {
        JedisCluster jedisCluster = createJedisCluster();
        return new JedisClient(jedisCluster);
    }

    private JedisCluster createJedisCluster() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMinIdle(1);
        jedisPoolConfig.setMaxIdle(5);
        jedisPoolConfig.setMaxTotal(5);
        jedisPoolConfig.setMaxWaitMillis(30000);

        Set<HostAndPort> nodes = new HashSet<>();
        // for each node add in nodes
        nodes.add(new HostAndPort("localhost", 6679));

        return new JedisCluster(nodes, 5000, 5000, 5, "foobared", jedisPoolConfig);
    }

}
