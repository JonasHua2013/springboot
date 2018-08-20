package com.practice.demo.configuration;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 添加配置
 * 
 * @author JonasHua
 *
 */
@Configuration
public class WebConfiguration {
	
	/**
	 * 添加远程IP过滤器
	 * 
	 * @return
	 */
	@Bean
    public RemoteIpFilter remoteIpFilter() {
        return new RemoteIpFilter();
    }
	
	/**
	 * 添加过滤器注册对象
	 * 
	 * @return
	 */
	@Bean
    public FilterRegistrationBean testFilterRegistration() {

        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new MyFilter());
        registration.addUrlPatterns("/*");
        registration.addInitParameter("paramName", "paramValue");
        registration.setName("MyFilter");
        registration.setOrder(1);
        return registration;
    }
	
	/**
	 * 自定义过滤器
	 * 
	 * @author JonasHua
	 *
	 */
	public class MyFilter implements Filter {
        @Override
        public void destroy() {
            // TODO Auto-generated method stub
        }

        @Override
        public void doFilter(ServletRequest srequest, ServletResponse sresponse, FilterChain filterChain)
                throws IOException, ServletException {
            // TODO Auto-generated method stub
            HttpServletRequest request = (HttpServletRequest) srequest;
            System.out.println("this is MyFilter,url :"+request.getRequestURI());
            filterChain.doFilter(srequest, sresponse);
        }

        @Override
        public void init(FilterConfig arg0) throws ServletException {
            // TODO Auto-generated method stub
        }
    }

}
