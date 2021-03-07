package com.xuejiexiong.service;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "redis_test")
public class RedisTestService {

	@Cacheable(key = "'save:key:'+#key")
	public String save(String key,String value) {
		return value;
	}
}
