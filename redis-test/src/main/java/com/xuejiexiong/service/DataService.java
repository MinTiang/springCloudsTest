package com.xuejiexiong.service;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.xuejiexiong.entity.DataEntity;

@Service
@CacheConfig(cacheNames = "data_entity")
public class DataService {

	@Cacheable(key = "'name:'+#dataEntity.name", unless = "#result == null ")
	public DataEntity save(DataEntity dataEntity) {
		return dataEntity;
	}

	@CachePut(key = "'name:'+#dataEntity.name", unless = "#result == null ")
	public DataEntity update(DataEntity dataEntity) {
		dataEntity.setAge(dataEntity.getAge()+1);
		return dataEntity;
	}

	@CacheEvict(key = "'name:'+#dataEntity.name")
	public void del(DataEntity dataEntity) {

	}
	
}
