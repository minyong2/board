package com.dw.board.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.dw.board.interceptor.Interceptor;

@Configuration // 설정파일 어노테이션 
public class WebConfig implements WebMvcConfigurer{

	@Autowired
	private Interceptor interceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//우리가 만든 interceptor를 스프링에 등록
		registry.addInterceptor(interceptor).excludePathPatterns("/api/v1/logs");
		// 이 url은 가로채지 말라는 뜻임 (요청을 해도 안 나옴) excludePathPatterns 안에 적은 url은 console에 찍어도 ip,url,Method가 안나옴
	
	}
	
	
}