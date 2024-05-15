package com.example.app.config;

import java.util.ResourceBundle;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ApplicationConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String location = bundle.getString("resource.location");
		
		registry.addResourceHandler("/uploads/**")
		.addResourceLocations(location);
	}
}
