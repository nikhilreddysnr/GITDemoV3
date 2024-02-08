package com.example.redis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@ComponentScan(basePackages = "com.example")
public class RedisConfiguration {

	@Bean
	public JedisConnectionFactory connectionFactory()
	{
		JedisConnectionFactory connectionFactory = new JedisConnectionFactory();
		connectionFactory.setHostName("localhost");
		connectionFactory.setPort(6379);
		connectionFactory.setUsePool(true);
		
		return connectionFactory;
		
		
	}
	@Bean
	public RedisTemplate<String, Object> redisTemplate()
	{
		RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
		
		template.setConnectionFactory(this.connectionFactory());
		template.setKeySerializer(new StringRedisSerializer());
		template.setHashKeySerializer(new StringRedisSerializer());
		template.setHashKeySerializer(new JdkSerializationRedisSerializer());
		template.setValueSerializer(new JdkSerializationRedisSerializer());
		template.setEnableTransactionSupport(true);
		template.afterPropertiesSet();
		
		return template;
		
	}
	
}
