package com.health.interceptors;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 
 * @author steve
 * 
 * 拦截器接口，通过{@link AccessConfig} 加入实现了该接口的拦截器，用法与servlet的拦截器完全一样。
 * 若使用了重定向，在使用过程中需要注意URL是否会产生多重重定向的问题。具体可以查看代码{@link InterceptorChain} 和 {@link BaseFilter}
 * 
 */
public interface Interceptor {
	
	public void doInterceptor(ServletRequest request, ServletResponse response,
			InterceptorChain chain) throws IOException, ServletException;;
	
}
