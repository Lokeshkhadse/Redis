//package com.example.Redis.redisConfig;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//
//@Configuration
//public class redisConfig {
//
//    @Bean
//    public RedisConnectionFactory redisConnectionFactory(){
//
//        return new LettuceConnectionFactory();
//    }
//
//
//    @Bean
//    public RedisTemplate<String,Object>redisTemplate(){
//
//        RedisTemplate<String,Object> redisTemplate = new RedisTemplate<>();
//
//        //1.connectionfactory
//        redisTemplate.setConnectionFactory(redisConnectionFactory());
//
//        //2.key serializer
//        redisTemplate.setKeySerializer(new StringRedisSerializer());
//
//        //3.value serializer
//        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
//
//
//        return redisTemplate;
//    }
//}
