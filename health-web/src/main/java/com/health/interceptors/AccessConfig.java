package com.health.interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * @author steve
 * 
 * <p>
 *  弃用spring security，改用自己写的权限拦截器链
 *  如果需要使用白名单策略，则添加下面的Bean，既可,使用的是spring 的路径匹配策略
 *
 * <pre class="code">
 *  &#064;Bean 
 *  public WhiteTable whiteTableConfig() {
 *		WhiteTable wt = new WhiteTable();
 *		wt.add("/authentication/*");
 *		wt.add("/WEB-INF/jsp/**");
 *		wt.add("/CSS/**");
 *		wt.add("/check/image");
 *		wt.add("/authentication/login/process");
 *		return wt;
 *  }
 * </pre>
 * </p>
 * 
 * <p>
 * 如果需要添加自己的拦截器，可以通过实现{@link Interceptor}接口，然后使用下面的代码添加进拦截器链即可
 * <pre class="code">
 *  &#064;Bean
 *  public InterceptorChain interceptorChainConfig() {
 *		InterceptorChain chain = new InterceptorChain();
 *		chain.addInterceptor(new SessionInterceptor());
 *		return chain;
 *  } 
 * </pre>
 * 
 * </p>
 *  
 */
@Configuration
public class AccessConfig {
	
	@Bean
	public WhiteTable whiteTableConfig() {
		WhiteTable wt = new WhiteTable();
		wt.add("/common/**");
		wt.add("/css/**");
		wt.add("/js/**");
		wt.add("/jsp/**");
		
		wt.add("/adminLogin/**");
		wt.add("/web/**");
		wt.add("/login");
		wt.add("/index");
		wt.add("/appLogin");
		wt.add("/error");
		wt.add("/errorPage");
		wt.add("/register/**");//手机注册接口
		wt.add("/userLogin/login");//手机登陆接口
		wt.add("/getImage/get");//图片访问接口
		wt.add("/question/**");//问卷页面
		return wt;
	}
	
	@Bean
	public NullSessionInterceptorChain interceptorChainConfig() {
		NullSessionInterceptorChain chain = new NullSessionInterceptorChain();
		chain.addInterceptor(accessTokenInterceptor);
		return chain;
	} 
	
	@Bean
	public SessionInterceptorChain sessionInterceptorChainConfig() {
		SessionInterceptorChain chain = new SessionInterceptorChain();
		chain.addInterceptor(sessionAccessTokenInterceptor);
		return chain;
	}
	
	/*-------------------------------------------------------------
	 *  拦截器注入
	 *-------------------------------------------------------------
	 */
	
	@Autowired
	public AccessTokenInterceptor accessTokenInterceptor;
	
	@Autowired
	public SessionAccessTokenInterceptor sessionAccessTokenInterceptor;
}
