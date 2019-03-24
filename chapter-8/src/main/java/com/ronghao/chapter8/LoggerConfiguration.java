package com.ronghao.chapter8;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**********************************
 * ============================== 
 * @author Ronghao Zhou          
 * @description
 * @date 7:47 PM 3/11/2018
 * ==============================
 **********************************/
@Configuration
public class LoggerConfiguration extends WebMvcConfigurerAdapter{
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoggerIntecptor()).addPathPatterns("/**");
    }
}

