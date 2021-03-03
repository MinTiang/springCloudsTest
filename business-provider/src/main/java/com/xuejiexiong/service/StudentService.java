package com.xuejiexiong.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xuejiexiong.entity.Student;
import com.xuejiexiong.responstry.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	@Transactional
	public Student save(Student student) {
		return studentRepository.save(student);
	}
	
	@Transactional
	public Student save(String id,String name,int age,boolean isMan) {
		Student student=new Student(name, age, isMan, new Date());
		return studentRepository.save(student);
	}
	
	public Student get(String id) {
		return studentRepository.getOne(id);
	}
	
	public List<Student> findAll(){
		return studentRepository.findAll();
	}
}
