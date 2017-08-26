package com.health.interceptors;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 
 * @author steve
 * 
 * 自定义的拦截器链，通过{@link BaseFilter}将该拦截器链加入进servlet拦截器栈中
 */
public class InterceptorChain {
	
	/**
	 * 拦截器链
	 */
	ArrayList<Interceptor> interceptorsChain = new ArrayList<Interceptor>();
	int currentPosition = 0;
	
	/**
	 * 递归调用拦截器链里面的拦截器
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	public void doInterceptor(ServletRequest request, ServletResponse response) throws IOException, ServletException {
		if(currentPosition == interceptorsChain.size()) {
			currentPosition = 0;
			return;
		}else {
			currentPosition ++;
			Interceptor nextInterceptor = interceptorsChain.get(currentPosition - 1);
			nextInterceptor.doInterceptor(request, response, this);
		}
	}
	
	public void init() {
		currentPosition = 0;
	}
	
	public void addInterceptor(Interceptor interceptor) {
		interceptorsChain.add(interceptor);
	}
}
