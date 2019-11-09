package com.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


//使用WebMvcConfigurerAdapter可以来扩展SpringMVC的功能
@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //super.addViewControllers(registry);
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index.html").setViewName("login");
    }

    @Configuration
    public class WebMvcConfig extends WebMvcConfigurerAdapter{
        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            //将所有/static/** 访问都映射到classpath:/static/ 目录下
            registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        }
    }

}
