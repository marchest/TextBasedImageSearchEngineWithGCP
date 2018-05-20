package com.xas.common.webConfig;


import java.io.File;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.xas.common.DbConfig.DatabaseConfig;

public class CustomerWebAppIntializer  implements WebApplicationInitializer {
	 private int maxUploadSizeInMb = 5 * 1024 * 1024; // 5 MB
	public void onStartup(ServletContext container) throws ServletException {

		AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
		webContext.register(DatabaseConfig.class);
		webContext.register(CustomerWebMVCConfig.class);
		webContext.setServletContext(container);
		
		   File uploadDirectory = new File(System.getProperty("java.io.tmpdir"));

	        // register a MultipartConfigElement
	        MultipartConfigElement multipartConfigElement =
	                new MultipartConfigElement(uploadDirectory.getAbsolutePath(),
	                        maxUploadSizeInMb, maxUploadSizeInMb * 2, maxUploadSizeInMb / 2);
		
		
        ServletRegistration.Dynamic registration = container.addServlet("dispatcherServlet", new DispatcherServlet(webContext));
        registration.setLoadOnStartup(1);
        registration.addMapping("/");
        registration.setMultipartConfig(multipartConfigElement);
        
        
	}
	 

	


}
