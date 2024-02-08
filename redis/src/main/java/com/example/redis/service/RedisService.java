package com.example.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.redis.dao.RedisDAO;

@Service
public class RedisService {

	@Autowired
	private RedisDAO redisDAO;
	
	public String rediscall(String name)
	{
		
		redisDAO.redisCall(name);
		return name;
		
	}
	
	public String readData(String key)
	{
		String value = redisDAO.readData(key);
		
		return value;
		
	}

	
	
}
