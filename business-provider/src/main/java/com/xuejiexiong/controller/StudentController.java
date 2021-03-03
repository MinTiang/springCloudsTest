package com.xuejiexiong.controller;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xuejiexiong.entity.Student;
import com.xuejiexiong.service.StudentService;
import com.xuejiexiong.vo.RestResponse;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping(value="/save",produces = {MediaType.APPLICATION_JSON})
	public RestResponse<Student> save(@RequestBody Student student) {
		return new RestResponse<Student>().success(studentService.save(student));
	}
	
	@PostMapping(value="/save2",produces = {MediaType.APPLICATION_JSON})
	public RestResponse<Student> save(String id,String name,int age,boolean isMan) {
		return new RestResponse<Student>().success(studentService.save(id,name,age,isMan));
	}
	
	@PostMapping(value="/getById",produces = {MediaType.APPLICATION_JSON})
	public RestResponse<Student> getById(String id) {
		return new RestResponse<Student>().success(studentService.get(id));
	}
	
	@PostMapping(value="/list",produces = {MediaType.APPLICATION_JSON})
	public RestResponse<List<Student>> list() {
		return new RestResponse<List<Student>>().success(studentService.findAll());
	}
	
}
