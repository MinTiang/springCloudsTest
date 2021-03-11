package com.xuejiexiong.entity;

import java.io.Serializable;

public class DataEntity implements Serializable {

	private String name;

	private int age;

	private Boolean isMan;

	public DataEntity() {
		super();
	}

	public DataEntity(String name, int age, Boolean isMan) {
		super();
		this.name = name;
		this.age = age;
		this.isMan = isMan;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Boolean getIsMan() {
		return isMan;
	}

	public void setIsMan(Boolean isMan) {
		this.isMan = isMan;
	}

}
