package com.example.redis.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.redis.service.RedisService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class RedisController {
	
	@Autowired
	private RedisService redisService;

	@RequestMapping(value="/", method = RequestMethod.POST)
	public String redisCall(@RequestBody String json) throws JsonMappingException, JsonProcessingException
	{
		try {
		 // Convert the JSON string to a Java object
	    Map<String, String> data = new ObjectMapper().readValue(json, Map.class);

	    // Get the value of the "name" property
	    String name = data.get("name");

	    // Get the value of the "value" property

	    // Do something with the values
	    System.out.println("Name: " + name);
	   redisService.rediscall(name);
		}
		catch (Exception e) {
			// TODO: handle exception
		e.printStackTrace();
		return "name not added";
		}
	    
		return "name successfully added to redis";
	}
	
	@RequestMapping(value="/read", method = RequestMethod.POST)
	public String readData(@RequestBody String json) throws JsonMappingException, JsonProcessingException
	{
		 Map<String, String> data = new ObjectMapper().readValue(json, Map.class);

		    // Get the value of the "name" property
		    String key = data.get("key");

		    // Get the value of the "value" property

		    // Do something with the values
		    System.out.println("key: " + key);
		    
		    String value = redisService.readData(key);
		
		return value;
		
	}
}
