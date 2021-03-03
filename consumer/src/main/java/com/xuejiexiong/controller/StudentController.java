package com.xuejiexiong.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.xuejiexiong.vo.RestResponse;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	RestTemplate restTemplate;
	@Autowired
	DiscoveryClient discoveryClient;

//	@PostMapping(value="/save",produces = {MediaType.APPLICATION_JSON})
//	public RestResponse<Student> save(@RequestBody Student student) {
//		return new RestResponse<Student>().success(studentService.save(student));
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
	
	@PostMapping(value="/list",produces = {MediaType.APPLICATION_JSON})
	public RestResponse<?> list() {
		List<ServiceInstance> list=discoveryClient.getInstances("business-provider");
		String url="http://localhost:9000/student/list";
		String result=restTemplate.postForObject(url, null, String.class);
		JSONObject json=JSONUtil.parseObj(result);
		return json.toBean(RestResponse.class);
	}
	
	@PostMapping(value="/getById",produces = {MediaType.APPLICATION_JSON})
	public RestResponse<?> getById(String id) throws Exception, IOException {
		List<ServiceInstance> list=discoveryClient.getInstances("business-provider");
		String url=list.get(0).getUri()+"/student/getById";
		MultiValueMap<String,String>  param=new LinkedMultiValueMap<String,String>();
		param.add("id", id);
		ResponseEntity<String> result=restTemplate.postForEntity(url, param, String.class);
		JSONObject json=JSONUtil.parseObj(result.getBody());
		return json.toBean(RestResponse.class);
	}
	
}
