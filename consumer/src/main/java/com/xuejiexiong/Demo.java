package com.xuejiexiong;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.InterceptingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;

import com.sun.jersey.api.client.ClientResponse;
import com.sun.xml.bind.v2.runtime.unmarshaller.Intercepter;

import cn.hutool.core.io.IoUtil;

public class Demo {

	public static void main(String[] args) throws IOException {
		SimpleClientHttpRequestFactory factory=new SimpleClientHttpRequestFactory();
		BasicAuthorizationInterceptor interceptors=new BasicAuthorizationInterceptor("xx", "as");
		InterceptingClientHttpRequestFactory interceptingClientHttpRequestFactory=new InterceptingClientHttpRequestFactory(factory, Arrays.asList(interceptors));
		ClientHttpRequest clientHttpRequest=interceptingClientHttpRequestFactory.createRequest(URI.create("http://www.baidu.com"), HttpMethod.GET);
//		clientHttpRequest.getHeaders().forEach((x,x1)->{System.out.println(x);System.out.println(x1);});
		ClientHttpResponse clientHttpResponse = clientHttpRequest.execute();
		System.out.println(IoUtil.read(clientHttpResponse.getBody(), "utf-8"));
		
		ClientHttpRequest clientHttpRequest2=interceptingClientHttpRequestFactory.createRequest(URI.create("http://www.alibaba.com"), HttpMethod.GET);
		ClientHttpResponse clientHttpResponse2 = clientHttpRequest2.execute();
		System.out.println(IoUtil.read(clientHttpResponse2.getBody(), "utf-8"));
		
		
		
	}
}
