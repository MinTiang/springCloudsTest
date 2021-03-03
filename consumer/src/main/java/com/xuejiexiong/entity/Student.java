package com.xuejiexiong.entity;

import java.io.Serializable;
import java.util.Date;

//@Table(name = "TH_STUDENT")
//@Entity
public class Student implements Serializable{

	private static final long serialVersionUID = 1L;
	
//	@Id
//	@Column(name="ID")
	private String id;
	
//	@Column(name = "NAME")
	private String name;
	
//	@Column(name = "AGE")
	private Integer age=1;
	
//	@Column(name = "IS_MAN")
	private Boolean isMan=true;
	
//	@Column(name = "CERATED_AT")
	private Date ceratedAt;

	
	public Student() {
		super();
	}

	public Student( String name, Integer age, Boolean isMan, Date ceratedAt) {
		super();
		this.name = name;
		this.age = age;
		this.isMan = isMan;
		this.ceratedAt = ceratedAt;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Boolean getIsMan() {
		return isMan;
	}

	public void setIsMan(Boolean isMan) {
		this.isMan = isMan;
	}

	public Date getCeratedAt() {
		return ceratedAt;
	}

	public void setCeratedAt(Date ceratedAt) {
		this.ceratedAt = ceratedAt;
	}
	
}
