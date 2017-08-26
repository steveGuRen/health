package com.health.interceptors;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


/**
 * 
 * @author steve
 * 
 *  <p>
 *  	通过注入拦截器链{@link InterceptorChain}以及白名单{@link WhiteTable}，实现自定义的接口访问控制
 *  </p>
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class BaseFilter implements Filter{
	
	private final Object delegateMonitor = new Object();
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
	    HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse)response;
        res.setHeader("Cache-Control", "no-cache");
        res.setHeader("Pragma", "no-cache");
        res.setDateHeader("expires", -1);
        String contextPath = req.getContextPath();
        String servletPath =req.getServletPath();
        if(whiteTable.isWhiteTableResource(servletPath)) {
        	chain.doFilter(request, response);
        }else if(HttpRequestDeviceUtils.isMobileDevice(req)){     //无session的拦截器链
        	interceptorChain.init();
        	interceptorChain.doInterceptor(request, response);
        	if(response.isCommitted()) {
        		return;
        	}else {
        		chain.doFilter(request, response);
        	}
        }
        else{     //有session的拦截器链
        	synchronized (this.delegateMonitor) {
        		sessionInterceptorChain.init();
        		sessionInterceptorChain.doInterceptor(request, response);
        	}
        	if(response.isCommitted()) {
        		return;
        	}else {
        		chain.doFilter(request, response);
        	}
        }
        
	}
	
	@Override
	public void destroy() {
	}
	
	@Autowired
	WhiteTable whiteTable;
	
	@Autowired
	NullSessionInterceptorChain interceptorChain;
	
	@Autowired
	SessionInterceptorChain sessionInterceptorChain;
	
	Logger log = LoggerFactory.getLogger(this.getClass());
}
 