package com.example.redis.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RedisDAO {

	@Autowired
	private RedisTemplate<String, Object> template;
	
	public String redisCall(String name)
	{
		
        template.opsForValue().set("name1"+name,name);
		
		return name;
		
	}
	
	public String readData(String key)
	{
		String value= (String) template.opsForValue().get(key);
		
		return value;
		
	}
}
