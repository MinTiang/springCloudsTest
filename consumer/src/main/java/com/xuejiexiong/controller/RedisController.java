package com.xuejiexiong.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xuejiexiong.service.RedisTestService;

@RestController
@RequestMapping("/redis")
public class RedisController {

	@Autowired
	RedisTemplate<Object, Object> redisTemplate;
	@Autowired
	RedisTestService redisTestService;
	
	@RequestMapping("/setValue")
	public String setVlue(@RequestParam String key,@RequestParam String value){
		value=redisTestService.save(key, value);
		return key+":"+value;
	} 
	
	@RequestMapping("/getValue")
	public String getVlue(@RequestParam String key){
		return (String) redisTemplate.opsForValue().get(key);
	} 
	
	@RequestMapping("/delValue")
	public void delVlue(@RequestParam String key){
	} 
	
}
