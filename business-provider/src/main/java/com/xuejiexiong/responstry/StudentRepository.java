package com.xuejiexiong.responstry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xuejiexiong.entity.Student;

public interface StudentRepository extends JpaRepository<Student, String> {

}
