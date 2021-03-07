package com.xuejiexiong.controller;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.xuejiexiong.entity.Student;
import com.xuejiexiong.service.BusinessProviderService;
import com.xuejiexiong.vo.RestResponse;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

@RestController
@RequestMapping("/student")
@CacheConfig(cacheNames = "student_controller")
public class StudentController {

	@Autowired
	RestTemplate restTemplate;
	@Autowired
	RedisTemplate redisTemplate;
	
	@Autowired
	BusinessProviderService businessProviderService;

//	@PostMapping(value="/save",consumes = {MediaType.APPLICATION_JSON},produces = {MediaType.APPLICATION_JSON})
//	public RestResponse<?> save(@RequestBody Student student) {
//		List<ServiceInstance> list=discoveryClient.getInstances("business-provider");
//		String url=list.get(0).getUri()+"/student/save";
//		MultiValueMap<String,String>  param=new LinkedMultiValueMap<String,String>();
//		param.add("id", "123");
//		param.add("name", "123");
//		param.add("age", "123");
//		param.add("isMan", "true");
//		ResponseEntity<String> result=restTemplate.postForEntity(url, param, String.class);
//		JSONObject json=JSONUtil.parseObj(result.getBody());
//		return json.toBean(RestResponse.class);
//	}
//	
//	@PostMapping(value="/save2",produces = {MediaType.APPLICATION_JSON})
//	public RestResponse<Student> save(String id,String name,int age,boolean isMan) {
//		return new RestResponse<Student>().success(studentService.save(id,name,age,isMan));
//	}
//	
//	@PostMapping(value="/getById",produces = {MediaType.APPLICATION_JSON})
//	public RestResponse<Student> getById(String id) {
//		return new RestResponse<Student>().success(studentService.get(id));
//	}
	
//	@PostMapping(value="/list",produces = {MediaType.APPLICATION_JSON})
//	public RestResponse<?> list() {
////		List<ServiceInstance> list=discoveryClient.getInstances("business-provider");
//		String url="http://business-provider/student/list";
//		String result=restTemplate.postForObject(url, null, String.class);
//		JSONObject json=JSONUtil.parseObj(result);
//		return json.toBean(RestResponse.class);
//	}
	
	@PostMapping(value="/list",produces = {MediaType.APPLICATION_JSON})
	@Cacheable(cacheNames = "list",unless = "#list!=null")
	public RestResponse<List<Student>> list() {
		RestResponse<List<Student>> result=businessProviderService.list();
		redisTemplate.opsForValue().set("123", result);
		return result;
	}
	@PostMapping(value="/cleanList",produces = {MediaType.APPLICATION_JSON})
	@CacheEvict(cacheNames = "list")
	public void cleanList() {
	}
	
//	@PostMapping(value="/getById",produces = {MediaType.APPLICATION_JSON})
//	public RestResponse<?> getById(String id) throws Exception, IOException {
//		List<ServiceInstance> list=discoveryClient.getInstances("business-provider");
//		String url=list.get(0).getUri()+"/student/getById";
//		MultiValueMap<String,String>  param=new LinkedMultiValueMap<String,String>();
//		param.add("id", id);
//		ResponseEntity<String> result=restTemplate.postForEntity(url, param, String.class);
//		JSONObject json=JSONUtil.parseObj(result.getBody());
//		return json.toBean(RestResponse.class);
//	}
	
}
