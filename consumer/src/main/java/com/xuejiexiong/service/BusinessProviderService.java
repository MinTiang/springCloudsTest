package com.xuejiexiong.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xuejiexiong.entity.Student;
import com.xuejiexiong.vo.RestResponse;

//@Service
@FeignClient(value = "business-provider")
public interface BusinessProviderService {

	@RequestMapping(value = "/student/list",method = RequestMethod.POST)
	@ResponseBody
	public RestResponse<List<Student>> list();
}
