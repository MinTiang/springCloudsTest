package com.xuejiexiong.vo;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class RestResponse<T> implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String state = "ok";

	private T data;
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date time;

	private String msg;

	public RestResponse<T> success(T data) {
		this.state = "ok";
		this.data = data;
		this.time = new Date();
		return this;
	}

	public RestResponse<T> error(String msg) {
		this.state = "error";
		this.time = new Date();
		this.msg = msg;
		return this;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
