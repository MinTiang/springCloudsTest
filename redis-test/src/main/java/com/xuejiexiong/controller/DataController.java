package com.xuejiexiong.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xuejiexiong.entity.DataEntity;
import com.xuejiexiong.service.DataService;

@RestController
@RequestMapping("/redis/test")
public class DataController {

	@Autowired
	DataService dataService;

	@RequestMapping(value = "/save")
	public DataEntity save(@RequestBody DataEntity dataEntity) {
		return dataService.save(dataEntity);
	}

	@RequestMapping(value = "/update")
	public DataEntity update(@RequestBody DataEntity dataEntity) {
		return dataService.update(dataEntity);
	}

	@RequestMapping(value = "/del")
	public void delete(@RequestBody DataEntity dataEntity) {
		dataService.del(dataEntity);
	}
}
