package com.xas.common.webConfig;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.session.MapSessionRepository;
import org.springframework.session.config.annotation.web.http.EnableSpringHttpSession;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
@EnableSpringHttpSession
@Configuration
@EnableWebMvc
@ComponentScan(basePackages={"com.xas"})
@EnableAsync
public class CustomerWebMVCConfig extends  WebMvcConfigurerAdapter {
	
	
//	
//	@Override
//	public void addViewControllers(ViewControllerRegistry registry) {
//		registry.addViewController("/").setViewName("home");
//		registry.addViewController("/home.action").setViewName("home");
//		registry.addViewController("/customer/customerForm.action").setViewName("addCustomer");
//	}
//	
	 @Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	    }
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	} 
	  @Bean
      public MapSessionRepository sessionRepository() {
              return new MapSessionRepository();
      }
	  @Bean
	    public MultipartResolver multipartResolver() {
	        return new StandardServletMultipartResolver();
	    }
	  
	  @Bean
	    public Executor asyncExecutor() {
	        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
	        executor.setCorePoolSize(2);
	        executor.setMaxPoolSize(2);
	        executor.setQueueCapacity(500);
	        executor.setThreadNamePrefix("GithubLookup-");
	        executor.initialize();
	        return executor;
	    }
	
}
