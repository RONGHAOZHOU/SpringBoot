package com.ronghao.chapter16;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;

import java.lang.reflect.Method;

/**********************************
 * ============================== 
 * @author Ronghao Zhou          
 * @description
 * @date 11:13 PM 3/19/2018
 * ==============================
 **********************************/

@Configuration
@EnableCaching
public class RedisConfiguration extends CachingConfigurerSupport {
    @Override
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object o, Method method, Object... objects) {
                StringBuffer sb = new StringBuffer();
                sb.append(o.getClass().getName());
                sb.append(method.getName());
                for (Object obj :
                        objects) {
                    sb.append(obj.toString());
                }

                return sb.toString();
            }
        };
    }

    public CacheManager cacheManager(RedisTemplate redisTemplate) {
        return new RedisCacheManager(redisTemplate);
    }
}
